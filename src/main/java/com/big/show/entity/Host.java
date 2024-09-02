package com.big.show.entity;

import com.big.show.enums.UserRole;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;

@Entity
public class Host extends AppUser{
	
	private String gender;
	@OneToOne
	private Address address;
	private String photoURL;
	private String idProof;
	private String idProofNumber;
	private String venueLicenseNumber;
	
	public Host(Integer userId, String userName, String password, UserRole role, String name, String phone,
			String email, String gender, Address address, String photoURL, String idProof, String idProofNumber,
			String venueLicenseNumber) {
		super(userId, userName, password, role, name, phone, email);
		this.gender = gender;
		this.address = address;
		this.photoURL = photoURL;
		this.idProof = idProof;
		this.idProofNumber = idProofNumber;
		this.venueLicenseNumber = venueLicenseNumber;
	}
	
	public Host() {
		
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

	public String getIdProof() {
		return idProof;
	}

	public void setIdProof(String idProof) {
		this.idProof = idProof;
	}

	public String getIdProofNumber() {
		return idProofNumber;
	}

	public void setIdProofNumber(String idProofNumber) {
		this.idProofNumber = idProofNumber;
	}

	public String getVenueLicenseNumber() {
		return venueLicenseNumber;
	}

	public void setVenueLicenseNumber(String venueLicenseNumber) {
		this.venueLicenseNumber = venueLicenseNumber;
	}

	@Override
	public String toString() {
		return "Host [gender=" + gender + ", address=" + address + ", photoURL=" + photoURL + ", idProof=" + idProof
				+ ", idProofNumber=" + idProofNumber + ", venueLicenseNumber=" + venueLicenseNumber + "]";
	}
	
	

}
