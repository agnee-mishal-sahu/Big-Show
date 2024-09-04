package com.big.show.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Host extends AppUser {

	private String gender;
	@OneToOne
	private Address address;
	private String photoURL;
	private String idProof;
	private String idProofNumber;
	private String venueLicenseNumber;
	private Date licenseExpiryDate;


}
