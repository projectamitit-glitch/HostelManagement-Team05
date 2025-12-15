package com.avsoft.hostelmanagement.service;

import java.util.List;

import com.avsoft.hostelmanagement.dto.FloorDto;
import com.avsoft.hostelmanagement.dto.GetFloorDto;
import com.avsoft.hostelmanagement.response.PaginationResponse;

public interface FloorService {

	void addFloor(Long buildingId, FloorDto floorDto);

	FloorDto getFloorById(Long id);

	List<FloorDto> getFloorByBuildingId(Long buildingId);

	PaginationResponse getAllFloors(Integer pageNumber, Integer pageSize);

	void deleteFloorById(Long floorId);
}
