package com.big.show.dto;

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
public class AppUserDto {
	
	private Integer userId;
	private String userName;
	private UserRole role;
	private String name;
	private String phone;
	private String email;
	private String gender;
}
