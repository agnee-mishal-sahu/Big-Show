package com.big.show.service.impl;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.big.show.constants.MessageConstant;
import com.big.show.constants.ValidationConstants;
import com.big.show.dto.AddressDto;
import com.big.show.dto.HostDto;
import com.big.show.dto.HostResponseDto;
import com.big.show.entity.Address;
import com.big.show.entity.Host;
import com.big.show.enums.LicenseStatus;
import com.big.show.enums.UserRole;
import com.big.show.exception.HostException;
import com.big.show.repository.HostRepository;
import com.big.show.service.AddressService;
import com.big.show.service.HostService;

@Service
public class HostServiceImpl implements HostService {

	@Autowired
	HostRepository hostRepository;

	@Autowired
	AddressService addressService;

	@Override
	public HostResponseDto signUpHost(Host host) throws HostException {

		HostResponseDto hostResponseDto = new HostResponseDto();
		Host hostEntity = new Host();

		if (host != null) {
			if (validateHost(host, true)) {

				host.setRole(UserRole.Host);

				if (host.getAddress() != null) {
					addressService.saveAddress(host.getAddress());
				}
				if (host.getLicenseExpiryDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate()
						.isAfter(LocalDate.now())) {
					
					host.setLicenseStatus(LicenseStatus.VALID);
				} else {
					host.setLicenseStatus(LicenseStatus.EXPIRED);
				}

				hostEntity = hostRepository.save(host);

				hostResponseDto.setUserId(hostEntity.getUserId());
				hostResponseDto.setUserName(hostEntity.getUserName());
				hostResponseDto.setRole(hostEntity.getRole());
				hostResponseDto.setVenueLicenseNumber(hostEntity.getVenueLicenseNumber());
				hostResponseDto.setLicenseStatus(hostEntity.getLicenseStatus());
				hostResponseDto.setStatus("Success");
			}
		}
		return hostResponseDto;
	}

	@Override
	public String updateProfile(HostDto hostDto, Integer userId) throws HostException {

		Optional<Host> hostOptional = hostRepository.findById(userId);
		Address address = new Address();

		if (hostOptional.isEmpty()) {
			throw new HostException(MessageConstant.USER_NOT_FOUND);
		}

		Host host = hostOptional.get();
		if (!host.getUserName().equals(hostDto.getUserName())) {
			if (hostRepository.findByUserName(hostDto.getUserName()).isPresent()) {
				throw new HostException(ValidationConstants.USERNAME_EXISTS);
			}
		}

		host.setUserName(hostDto.getUserName());
		host.setName(hostDto.getName());
		host.setPhone(hostDto.getPhone());
		host.setEmail(hostDto.getEmail());
		host.setGender(hostDto.getGender());
		host.setPhotoURL(hostDto.getPhotoURL());
		host.setIdProof(hostDto.getIdProof());
		host.setIdProofNumber(hostDto.getIdProofNumber());
		host.setVenueLicenseNumber(hostDto.getVenueLicenseNumber());
		host.setLicenseExpiryDate(hostDto.getLicenseExpiryDate());
		if (host.getLicenseExpiryDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate()
				.isAfter(LocalDate.now())) {
			
			host.setLicenseStatus(LicenseStatus.VALID);
		} else {
			host.setLicenseStatus(LicenseStatus.EXPIRED);
		}

		if (host.getAddress() != null) {
			address = host.getAddress();
			address.setAddress1(hostDto.getAddress().getAddress1());
			address.setCity(hostDto.getAddress().getCity());
			address.setCountry(hostDto.getAddress().getCountry());
			address.setNearBy(hostDto.getAddress().getNearBy());
			address.setZip(hostDto.getAddress().getZip());

			addressService.saveAddress(address);
			host.setAddress(address);
		}

		if (validateHost(host, false)) {
			hostRepository.save(host);
		}

		return MessageConstant.USER_UPDATED + hostDto.getUserName();
	}

	@Override
	public HostDto getHostById(Integer userId) throws HostException {

		Optional<Host> hostOptional = hostRepository.findById(userId);
		HostDto hostResponse = new HostDto();
		AddressDto addressResponse = new AddressDto();

		if (hostOptional.isEmpty()) {
			throw new HostException(MessageConstant.USER_NOT_FOUND);
		}
		Host host = hostOptional.get();
		hostResponse.setUserName(host.getUserName());
		hostResponse.setName(host.getName());
		hostResponse.setRole(host.getRole());
		hostResponse.setPhone(host.getPhone());
		hostResponse.setEmail(host.getEmail());
		hostResponse.setGender(host.getGender());
		hostResponse.setPhotoURL(host.getPhotoURL());
		hostResponse.setVenueLicenseNumber(host.getVenueLicenseNumber());
		hostResponse.setLicenseStatus(host.getLicenseStatus());

		addressResponse.setAddress1(host.getAddress().getAddress1());
		addressResponse.setCity(host.getAddress().getCity());
		addressResponse.setCountry(host.getAddress().getCountry());
		addressResponse.setNearBy(host.getAddress().getNearBy());
		addressResponse.setZip(host.getAddress().getZip());
		hostResponse.setAddress(addressResponse);

		return hostResponse;
	}

	@Override
	public String deleteHost(Integer userId) throws HostException {

		Optional<Host> hostOptional = hostRepository.findById(userId);
		Address address = new Address();

		if (hostOptional.isEmpty()) {
			throw new HostException(MessageConstant.USER_NOT_FOUND);
		}
		Host host = hostOptional.get();

		if (host.getAddress() != null) {
			address = addressService.getAddress(host.getAddress().getAddressId());
		}
		hostRepository.delete(host);

		if (address != null) {
			addressService.deleteAddress(address);
		}

		return MessageConstant.USER_DELETED;
	}

	private boolean validateHost(Host host, boolean isSignUp) throws HostException {

		String emailRegex = "^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$";
		String phoneRegex = "^\\d{10}$";

		if (host.getUserName().isBlank()) {
			throw new HostException(ValidationConstants.BLANK_USERNAME);
		}
		if (host.getPassword().isBlank() && isSignUp) {
			throw new HostException(ValidationConstants.BLANK_PASSWORD);
		}
		if (!host.getEmail().matches(emailRegex)) {
			throw new HostException(ValidationConstants.INVALID_EMAIL);
		}
		if (!host.getPhone().matches(phoneRegex)) {
			throw new HostException(ValidationConstants.INVALID_PHONE);
		}
		if (hostRepository.findByUserName(host.getUserName()).isPresent() && isSignUp) {
			throw new HostException(ValidationConstants.USERNAME_EXISTS);
		}
		return true;
	}

}
