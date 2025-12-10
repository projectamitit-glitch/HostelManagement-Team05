package com.avsoft.hostelmanagement.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Bed {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String bedNo;
	private String status;

	private String price;
	private int sharing;
    private Long deposit;
	private boolean booked;
	private LocalDate bookedFrom;
	private LocalDate bookedTo;

	@ManyToOne
	@JoinColumn(name = "room_id")
	private Room room;
}
