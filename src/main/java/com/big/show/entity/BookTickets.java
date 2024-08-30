package com.big.show.entity;

import java.time.LocalTime;
import java.util.Date;
import java.util.List;

import com.big.show.enums.BookingStatus;

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
public class BookTickets {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer bookingId;
	private Integer showId;
	private Integer venueId;
	private Integer userId;
	private Integer numberOfTickets;
	private Double totalPrice;
	private List<String> seatNumbers;
	private Date showDate;
	private LocalTime showTiming;
	private boolean isPaymentDone;
	private BookingStatus status;
}
