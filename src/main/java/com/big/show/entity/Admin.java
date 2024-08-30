package com.big.show.entity;

import com.big.show.enums.UserRole;

import jakarta.persistence.Entity;

@Entity
public class Admin extends AppUser{

	public Admin() {
		super();
	}

	public Admin(Integer userId, String userName, String password, UserRole role, String name, String phone,
			String email) {
		super(userId, userName, password, role, name, phone, email);
		
	}
	

}
