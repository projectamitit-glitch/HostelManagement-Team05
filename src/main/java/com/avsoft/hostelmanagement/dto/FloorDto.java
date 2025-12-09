package com.avsoft.hostelmanagement.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class FloorDto {
	
	private Long id;
    private int floorNo;
    private int noOfRooms;
    private String floorType; 
    private String status;
    
    private Long buildingId;
    
    private String buildingName;
    private String hostelName;
    private String orgName;

}
