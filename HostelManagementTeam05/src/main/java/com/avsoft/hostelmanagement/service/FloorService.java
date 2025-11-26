package com.avsoft.hostelmanagement.service;

import java.util.List;

import com.avsoft.hostelmanagement.dto.FloorDto;

public interface FloorService {

    FloorDto createFloor(FloorDto dto);

    FloorDto getFloorById(Long id);

    List<FloorDto> getAllFloors();

    List<FloorDto> getFloorsByBuilding(Long buildingId);

    FloorDto updateFloor(Long id, FloorDto dto);

    void deleteFloor(Long id);
}