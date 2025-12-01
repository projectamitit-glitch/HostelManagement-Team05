package com.avsoft.hostelmanagement.dto;

import lombok.Data;

@Data
public class RoomDto {
	
	private Long id;
	private int roomNo;	
	private String type;
	private String status;	
	private double pricePerBed;
	
}
