package com.avsoft.hostelmanagement.service;

import java.util.List;

import com.avsoft.hostelmanagement.dto.BuildingDto;
import com.avsoft.hostelmanagement.entity.Building;

public interface BuildingService {
	
	
	Building saveBuilding(Long hostelId,BuildingDto dto);
	
	Building getBuildingById(Long id);
	void deleteBuilding(Long id);
	
	void deleteAllBuilding();

}
