package com.big.show.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.big.show.constants.MessageConstant;
import com.big.show.constants.ValidationConstants;
import com.big.show.dto.AdminDto;
import com.big.show.dto.AdminResponseDto;
import com.big.show.entity.Admin;
import com.big.show.enums.UserRole;
import com.big.show.exception.AdminException;
import com.big.show.repository.AdminRepository;
import com.big.show.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	AdminRepository adminRepository;

	@Override
	public AdminResponseDto createAdmin(Admin admin) throws AdminException {

		AdminResponseDto adminResponseDto = new AdminResponseDto();
		Admin adminEntity = new Admin();

		if (admin != null) {
			if (validateAdmin(admin, true)) {

				admin.setRole(UserRole.Admin);

				adminEntity = adminRepository.save(admin);

				adminResponseDto.setUserId(adminEntity.getUserId());
				adminResponseDto.setUserName(adminEntity.getUserName());
				adminResponseDto.setRole(adminEntity.getRole());
				adminResponseDto.setStatus("Success");
			}
		}
		return adminResponseDto;
	}

	@Override
	public String updateAdmin(AdminDto adminDto, Integer userId) throws AdminException {

		Optional<Admin> adminOptional = adminRepository.findById(userId);

		if (adminOptional.isEmpty()) {
			throw new AdminException(MessageConstant.USER_NOT_FOUND);
		}

		Admin admin = adminOptional.get();
		if (!admin.getUserName().equals(adminDto.getUserName())) {
			if (adminRepository.findByUserName(adminDto.getUserName()).isPresent()) {
				throw new AdminException(ValidationConstants.USERNAME_EXISTS);
			}
		}
		admin.setUserName(adminDto.getUserName());
		admin.setName(adminDto.getName());
		admin.setPhone(adminDto.getPhone());
		admin.setEmail(adminDto.getEmail());

		if (validateAdmin(admin, false)) {
			adminRepository.save(admin);
		}

		return MessageConstant.USER_UPDATED + adminDto.getUserName();
	}

	@Override
	public AdminDto getAdminById(Integer userId) throws AdminException {
		
		Optional<Admin> adminOptional = adminRepository.findById(userId);
		AdminDto adminResponse = new AdminDto();
		if (adminOptional.isEmpty()) {
			throw new AdminException(MessageConstant.USER_NOT_FOUND);
		}

		Admin admin = adminOptional.get();
		adminResponse.setUserName(admin.getUserName());
		adminResponse.setName(admin.getName());
		adminResponse.setRole(admin.getRole());
		adminResponse.setPhone(admin.getPhone());
		adminResponse.setEmail(admin.getEmail());

		return adminResponse;
	}

	@Override
	public String deleteAdmin(Integer userId) throws AdminException {
		
		Optional<Admin> adminOptional = adminRepository.findById(userId);

		if (adminOptional.isEmpty()) {
			throw new AdminException(MessageConstant.USER_NOT_FOUND);
		}
		Admin admin = adminOptional.get();

		adminRepository.delete(admin);

		return MessageConstant.USER_DELETED;
	}

	private boolean validateAdmin(Admin admin, boolean isSignUp) throws AdminException {
		String emailRegex = "^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$";
		String phoneRegex = "^\\d{10}$";

		if (admin.getUserName().isBlank()) {
			throw new AdminException(ValidationConstants.BLANK_USERNAME);
		}
		if (admin.getPassword().isBlank() && isSignUp) {
			throw new AdminException(ValidationConstants.BLANK_PASSWORD);
		}
		if (!admin.getEmail().matches(emailRegex)) {
			throw new AdminException(ValidationConstants.INVALID_EMAIL);
		}
		if (!admin.getPhone().matches(phoneRegex)) {
			throw new AdminException(ValidationConstants.INVALID_PHONE);
		}
		if (adminRepository.findByUserName(admin.getUserName()).isPresent() && isSignUp) {
			throw new AdminException(ValidationConstants.USERNAME_EXISTS);
		}
		return true;
	}

}
