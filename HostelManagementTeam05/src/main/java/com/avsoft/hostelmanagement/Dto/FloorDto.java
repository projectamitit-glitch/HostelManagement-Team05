package com.avsoft.hostelmanagement.Dto;

import lombok.Data;

@Data
public class FloorDto {
	
	private Long id;
    private int floorNo;
    private int noOfRooms;
    private String floorType; 
    private String status;

}
