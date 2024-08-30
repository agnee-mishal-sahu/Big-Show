package com.big.show.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Venue {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer venueId;
	private String venueName;
	private Integer numberOfSeats;
	private Integer numberOfRows;
	private Integer numberOfColumns;
	private String description;
	private List<Integer> showsList;
	private Integer hostId;
	private String location;
	private String city;
	
	
}
