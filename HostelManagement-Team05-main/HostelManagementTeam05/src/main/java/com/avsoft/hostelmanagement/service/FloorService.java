package com.avsoft.hostelmanagement.service;

import java.util.List;

import com.avsoft.hostelmanagement.dto.FloorDto;
import com.avsoft.hostelmanagement.dto.GetFloorDto;

public interface FloorService {
	
    void addFloor(Long buildingId, FloorDto floorDto);

    FloorDto getFloorById(Long id);

    List<FloorDto> getFloorByBuildingId(Long buildingId);

    List<FloorDto> getAllFloors();

    void deleteFloorById(Long floorId);
}
