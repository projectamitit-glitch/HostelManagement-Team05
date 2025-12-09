package com.avsoft.hostelmanagement.dto;

import lombok.Data;

@Data
public class AddAddressDto {

	private String area;
	private String city;
	private int zipCode;
	private String state;

}
