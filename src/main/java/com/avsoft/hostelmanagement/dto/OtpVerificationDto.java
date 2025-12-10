package com.avsoft.hostelmanagement.dto;

import lombok.Data;

@Data
public class OtpVerificationDto {
	
	private String email;
	private String otp;

}
