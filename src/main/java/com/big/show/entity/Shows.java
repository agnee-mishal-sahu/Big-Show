package com.big.show.entity;

import java.util.Date;
import java.util.List;

import com.big.show.constants.MessageConstant;
import com.big.show.enums.ShowType;
import com.fasterxml.jackson.annotation.JsonFormat;

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
public class Shows {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
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
