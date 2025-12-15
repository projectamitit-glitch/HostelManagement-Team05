package com.avsoft.hostelmanagement.service;

import java.util.List;

import com.avsoft.hostelmanagement.dto.BuildingDto;
import com.avsoft.hostelmanagement.entity.Building;
import com.avsoft.hostelmanagement.response.PaginationResponse;

public interface BuildingService {

	Building saveBuilding(Long hostelId, BuildingDto dto);

	Building getBuildingById(Long id);

	PaginationResponse getAllBuilding(Integer pageNumber, Integer pageSize);

	void deleteBuilding(Long id);

	void deleteAllBuilding();

}
