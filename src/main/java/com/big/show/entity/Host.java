package com.big.show.entity;

import java.util.Date;

import com.big.show.enums.LicenseStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Host extends AppUser {

	@OneToOne
	private Address address;
	private String photoURL;
	private String idProof;
	private String idProofNumber;
	private String venueLicenseNumber;
	private Date licenseExpiryDate;
	@Enumerated(EnumType.STRING)
	private LicenseStatus licenseStatus;


}
