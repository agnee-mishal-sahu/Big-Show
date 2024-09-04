package com.big.show.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressDto {

	private String address1;
	private Integer zip;
	private String city;
	private String country;
	private String nearBy;

}
