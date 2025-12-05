package com.avsoft.hostelmanagement.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.data.convert.Jsr310Converters.LocalDateTimeToDateConverter;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String fullName;
	private String currentAddress;
	private String permanentAddress;
	private LocalDate dateOfBirth;
	private long mobileNo;
	private String email;
	private String education;
	private long adharNo;
	private String parentName;
	private long parentMobileNo;
	private String gender;
	private String profession;
	private String maritalStatus;
	private String userName;

	private String password;
	private LocalDateTime createdDate;
	private LocalDateTime updatedDate;
	private String role;
	
	
	private String otp;
	
	private LocalDateTime otpGeneratedAt;
	
	private  boolean emailVerified = false;

}
