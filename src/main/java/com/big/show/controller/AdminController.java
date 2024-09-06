package com.big.show.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.big.show.dto.AdminDto;
import com.big.show.entity.Admin;
import com.big.show.exception.AdminException;
import com.big.show.service.AdminService;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	AdminService adminService;
	
	@PostMapping("/signup")
	ResponseEntity<?> signUpAdmin(@RequestBody Admin admin) throws AdminException {
		return new ResponseEntity<>(adminService.createAdmin(admin), HttpStatus.CREATED);
	}

	@PutMapping("/update/{userid}")
	ResponseEntity<?> updateProfile(@RequestBody AdminDto adminDto, @PathVariable Integer userid) throws AdminException {
		return new ResponseEntity<>(adminService.updateAdmin(adminDto, userid), HttpStatus.OK);
	}

	@GetMapping("/{userid}")
	ResponseEntity<?> getAdminById(@PathVariable Integer userid) throws AdminException {
		return new ResponseEntity<>(adminService.getAdminById(userid), HttpStatus.OK);
	}

	@DeleteMapping("/{userid}")
	ResponseEntity<?> deleteAdmin(@PathVariable Integer userid) throws AdminException {
		return new ResponseEntity<>(adminService.deleteAdmin(userid), HttpStatus.OK);
	}
}
