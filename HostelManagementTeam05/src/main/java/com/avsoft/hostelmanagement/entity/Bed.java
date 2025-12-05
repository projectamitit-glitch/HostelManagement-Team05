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
<<<<<<< HEAD
	private String status;
=======
	private String status; // AVAILABLE / BOOKED
>>>>>>> remotes/origin/feature/samiksha/#11

	private String price;
	private int sharing;

	private boolean booked;
	private LocalDate bookedFrom;
	private LocalDate bookedTo;
<<<<<<< HEAD

	@ManyToOne
	@JoinColumn(name = "room_id")
	private Room room;
=======

	@ManyToOne
	@JoinColumn(name = "room_id")
	private Room room;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBedNo() {
		return bedNo;
	}

	public void setBedNo(String bedNo) {
		this.bedNo = bedNo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public int getSharing() {
		return sharing;
	}

	public void setSharing(int sharing) {
		this.sharing = sharing;
	}

	public boolean isBooked() {
		return booked;
	}

	public void setBooked(boolean booked) {
		this.booked = booked;
	}

	public LocalDate getBookedFrom() {
		return bookedFrom;
	}

	public void setBookedFrom(LocalDate bookedFrom) {
		this.bookedFrom = bookedFrom;
	}

	public LocalDate getBookedTo() {
		return bookedTo;
	}

	public void setBookedTo(LocalDate bookedTo) {
		this.bookedTo = bookedTo;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

>>>>>>> remotes/origin/feature/samiksha/#11
}
