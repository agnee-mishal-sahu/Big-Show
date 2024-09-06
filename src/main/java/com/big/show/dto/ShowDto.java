package com.big.show.dto;

import java.util.Date;
import java.util.List;

import com.big.show.constants.MessageConstant;
import com.big.show.enums.ShowType;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(Include.NON_EMPTY)
public class ShowDto {

	private Integer showId;
	private Integer venueId;
	private String showName;
	private ShowType showType;
	private String description;
	private List<String> languages;
	private List<String> cast;
	private List<String> genre;
	private List<String> format;
	private Date releaseDate;
	private String runtime;
	private boolean isLive;
	@JsonFormat(pattern = MessageConstant.DATE_FORMAT)
	private List<Date> showDatesWithTimings;
	private Integer ticketPrice;
	
}
