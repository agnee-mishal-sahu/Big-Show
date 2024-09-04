package com.big.show.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(Include.NON_EMPTY)
public class HostDto extends AppUserDto{
	
	private String gender;
	private AddressDto address;
	private String photoURL;
	private String idProof;
	private String idProofNumber;
	private String venueLicenseNumber;
	private Date licenseExpiryDate;
	
}
