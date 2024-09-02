package com.big.show.dto;

import java.util.Date;

import com.big.show.entity.Address;
import com.big.show.enums.UserRole;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_EMPTY)
public class MemberDto extends AppUserDto{
	
	private String gender;
	private Address address;
	private String photoURL;
	private Date birthday;
	
	public MemberDto(Integer userId, String userName, UserRole role, String name, String phone,
			String email, String gender, Address address, String photoURL, Date birthday) {
		super(userId, userName, role, name, phone, email);
		this.gender = gender;
		this.address = address;
		this.photoURL = photoURL;
		this.birthday = birthday;
	}
	
	public MemberDto() {
		
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
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
