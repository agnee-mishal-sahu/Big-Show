package com.big.show.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(Include.NON_EMPTY)
public class VenueDto {
	
	private Integer venueId;
	private String venueName;
	private Integer numberOfSeats;
	private Integer numberOfRows;
	private Integer numberOfColumns;
	private String description;
	private List<ShowDto> showsList;
	private Integer hostId;
	private String location;
	private String city;
}
