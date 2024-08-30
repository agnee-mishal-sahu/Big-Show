package com.big.show.entity;

import java.util.Date;

import com.big.show.enums.Gender;
import com.big.show.enums.UserRole;

import jakarta.persistence.Entity;

@Entity
public class Member extends AppUser{

	private Gender gender;
	private Address address;
	private String photoURL;
	private Date birthday;
	
	public Member(Integer userId, String userName, String password, UserRole role, String name, String phone,
			String email, Gender gender, Address address, String photoURL, Date birthday) {
		super(userId, userName, password, role, name, phone, email);
		this.gender = gender;
		this.address = address;
		this.photoURL = photoURL;
		this.birthday = birthday;
	}
	
	public Member() {
		
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getPhotoURL() {
		return photoURL;
	}

	public void setPhotoURL(String photoURL) {
		this.photoURL = photoURL;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	@Override
	public String toString() {
		return "Member [gender=" + gender + ", address=" + address + ", photoURL=" + photoURL + ", birthday=" + birthday
				+ "]";
	}
	
	
	
}
