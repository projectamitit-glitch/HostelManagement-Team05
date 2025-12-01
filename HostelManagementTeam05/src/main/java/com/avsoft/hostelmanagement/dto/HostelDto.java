package com.avsoft.hostelmanagement.dto;

import lombok.Data;

@Data
public class HostelDto {

	private String name;
	private String address;
	private int capacity;
	private String contactNo;
	private String genderType;
	private Long organizationId;

}
