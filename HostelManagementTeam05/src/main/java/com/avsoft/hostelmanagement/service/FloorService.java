package com.avsoft.hostelmanagement.service;

import java.util.List;

import com.avsoft.hostelmanagement.dto.FloorDto;
import com.avsoft.hostelmanagement.dto.GetFloorDto;

public interface FloorService {
	void addFloor(int buildingId, FloorDto floorDto);

	List<GetFloorDto> getFloorByBuildingId(int id);

	GetFloorDto getFloorById(int id);

	List<GetFloorDto> getAllFloors();

	void deleteFloorById(int id);

}
