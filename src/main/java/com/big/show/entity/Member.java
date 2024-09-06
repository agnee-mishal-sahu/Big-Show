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
public class Member extends AppUser{

	@OneToOne
	private Address address;
	private String photoURL;
	private Date birthday;
	
}
