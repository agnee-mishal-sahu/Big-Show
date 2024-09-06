package com.big.show.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.big.show.constants.MessageConstant;
import com.big.show.constants.ValidationConstants;
import com.big.show.dto.AddressDto;
import com.big.show.dto.MemberDto;
import com.big.show.dto.MemberResponseDto;
import com.big.show.entity.Address;
import com.big.show.entity.Member;
import com.big.show.enums.UserRole;
import com.big.show.exception.MemberException;
import com.big.show.repository.MemberRepository;
import com.big.show.service.AddressService;
import com.big.show.service.MemberService;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	MemberRepository memberRepository;

	@Autowired
	AddressService addressService;

	@Override
	public MemberResponseDto signUpUser(Member member) throws MemberException {

		MemberResponseDto memberResponseDto = new MemberResponseDto();
		Member memberEntity = new Member();

		if (member != null) {
			if (validateMember(member, true)) {

				member.setRole(UserRole.Member);

				if (member.getAddress() != null) {
					addressService.saveAddress(member.getAddress());
				}
				memberEntity = memberRepository.save(member);

				memberResponseDto.setUserId(memberEntity.getUserId());
				memberResponseDto.setUserName(memberEntity.getUserName());
				memberResponseDto.setRole(memberEntity.getRole());
				memberResponseDto.setStatus("Success");
			}
		}
		return memberResponseDto;
	}

	@Override
	public String updateProfile(MemberDto memberDto, Integer userId) throws MemberException {

		Optional<Member> memberOptional = memberRepository.findById(userId);
		Address address = new Address();

		if (memberOptional.isEmpty()) {
			throw new MemberException(MessageConstant.USER_NOT_FOUND);
		}

		Member member = memberOptional.get();
		if (!member.getUserName().equals(memberDto.getUserName())) {
			if (memberRepository.findByUserName(memberDto.getUserName()).isPresent()) {
				throw new MemberException(ValidationConstants.USERNAME_EXISTS);
			}
		}

		member.setUserName(memberDto.getUserName());
		member.setName(memberDto.getName());
		member.setPhone(memberDto.getPhone());
		member.setEmail(memberDto.getEmail());
		member.setGender(memberDto.getGender());
		member.setPhotoURL(memberDto.getPhotoURL());
		member.setBirthday(memberDto.getBirthday());

		if (member.getAddress() != null) {
			address = member.getAddress();
			address.setAddress1(memberDto.getAddress().getAddress1());
			address.setCity(memberDto.getAddress().getCity());
			address.setCountry(memberDto.getAddress().getCountry());
			address.setNearBy(memberDto.getAddress().getNearBy());
			address.setZip(memberDto.getAddress().getZip());

			addressService.saveAddress(address);
			member.setAddress(address);
		}

		if (validateMember(member, false)) {
			memberRepository.save(member);
		}

		return MessageConstant.USER_UPDATED + memberDto.getUserName();
	}

	@Override
	public MemberDto getMemberById(Integer userId) throws MemberException {

		Optional<Member> memberOptional = memberRepository.findById(userId);
		MemberDto memberResponse = new MemberDto();
		AddressDto addressResponse = new AddressDto();

		if (memberOptional.isEmpty()) {
			throw new MemberException(MessageConstant.USER_NOT_FOUND);
		}
		Member member = memberOptional.get();
		memberResponse.setUserName(member.getUserName());
		memberResponse.setName(member.getName());
		memberResponse.setRole(member.getRole());
		memberResponse.setPhone(member.getPhone());
		memberResponse.setEmail(member.getEmail());
		memberResponse.setGender(member.getGender());
		memberResponse.setPhotoURL(member.getPhotoURL());
		memberResponse.setBirthday(member.getBirthday());

		addressResponse.setAddress1(member.getAddress().getAddress1());
		addressResponse.setCity(member.getAddress().getCity());
		addressResponse.setCountry(member.getAddress().getCountry());
		addressResponse.setNearBy(member.getAddress().getNearBy());
		addressResponse.setZip(member.getAddress().getZip());
		memberResponse.setAddress(addressResponse);

		return memberResponse;
	}

	@Override
	public String deleteMember(Integer userId) throws MemberException {

		Optional<Member> memberOptional = memberRepository.findById(userId);
		Address address = new Address();

		if (memberOptional.isEmpty()) {
			throw new MemberException(MessageConstant.USER_NOT_FOUND);
		}
		Member member = memberOptional.get();

		if (member.getAddress() != null) {
			address = addressService.getAddress(member.getAddress().getAddressId());
		}
		memberRepository.delete(member);

		if (address != null) {
			addressService.deleteAddress(address);
		}

		return MessageConstant.USER_DELETED;
	}

	private boolean validateMember(Member member, boolean isSignUp) throws MemberException {
		String emailRegex = "^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$";
		String phoneRegex = "^\\d{10}$";

		if (member.getUserName().isBlank()) {
			throw new MemberException(ValidationConstants.BLANK_USERNAME);
		}
		if (member.getPassword().isBlank() && isSignUp) {
			throw new MemberException(ValidationConstants.BLANK_PASSWORD);
		}
		if (!member.getEmail().matches(emailRegex)) {
			throw new MemberException(ValidationConstants.INVALID_EMAIL);
		}
		if (!member.getPhone().matches(phoneRegex)) {
			throw new MemberException(ValidationConstants.INVALID_PHONE);
		}
		if (memberRepository.findByUserName(member.getUserName()).isPresent() && isSignUp) {
			throw new MemberException(ValidationConstants.USERNAME_EXISTS);
		}
		return true;
	}

}
