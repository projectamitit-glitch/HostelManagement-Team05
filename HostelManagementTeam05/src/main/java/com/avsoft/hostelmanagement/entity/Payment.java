package com.avsoft.hostelmanagement.entity;

import java.time.LocalDateTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String orderId; // razorpay orderId
	private String paymentId; // razorpay paymentId
	private String status; // SUCCESS / FAILED
	private int amount; // Amount in INR
	private String method; // card / upi / wallet / netbanking
	private String email; // Customer email
	private String contact; // Customer phone
	private LocalDateTime createdAt;
	private String paymentSource;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "book_id")
	private Booking booking;

}
