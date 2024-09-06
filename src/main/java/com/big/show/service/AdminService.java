package com.big.show.service;

import com.big.show.dto.AdminDto;
import com.big.show.dto.AdminResponseDto;
import com.big.show.entity.Admin;
import com.big.show.exception.AdminException;

public interface AdminService {
	
	AdminResponseDto createAdmin(Admin admin) throws AdminException;
	String updateAdmin(AdminDto adminDto,Integer userId) throws AdminException;
	AdminDto getAdminById(Integer userId) throws AdminException;
	String deleteAdmin(Integer userId) throws AdminException;

}
