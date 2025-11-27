package com.avsoft.hostelmanagement.Dto;

import lombok.Data;

@Data
public class BuildingDto {
	
	private Long id;
    private int floors;
    private String name;
    private String warden;
    private boolean maintenanceRequired;
}
