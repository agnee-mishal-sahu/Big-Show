package com.big.show.dto;

import com.big.show.enums.LicenseStatus;
import com.big.show.enums.UserRole;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(Include.NON_EMPTY)
public class HostResponseDto {
	
	private Integer userId;
	private String userName;
	private UserRole role;
	private String venueLicenseNumber;
	private LicenseStatus licenseStatus;
	private String status;
}
