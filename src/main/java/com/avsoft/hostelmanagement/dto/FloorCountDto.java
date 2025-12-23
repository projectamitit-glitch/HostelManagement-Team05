package com.avsoft.hostelmanagement.dto;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FloorCountDto {
	private Long buildingId;
    private long floorCount;
}

