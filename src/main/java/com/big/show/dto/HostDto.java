package com.big.show.dto;

import java.util.Date;

import com.big.show.enums.LicenseStatus;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(Include.NON_EMPTY)
public class HostDto extends AppUserDto{
	
	private AddressDto address;
	private String photoURL;
	private String idProof;
	private String idProofNumber;
	private String venueLicenseNumber;
	private Date licenseExpiryDate;
	@Enumerated(EnumType.STRING)
	private LicenseStatus licenseStatus;
	
}
