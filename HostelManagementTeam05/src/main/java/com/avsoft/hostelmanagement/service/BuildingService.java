package com.avsoft.hostelmanagement.service;

import java.util.List;

import com.avsoft.hostelmanagement.dto.BuildingDto;

public interface BuildingService {

    BuildingDto createBuilding(BuildingDto dto);

    BuildingDto getBuildingById(Long id);

    List<BuildingDto> getAllBuildings();

    List<BuildingDto> getBuildingsByHostel(Long hostelId);

    BuildingDto updateBuilding(Long id, BuildingDto dto);

    void deleteBuilding(Long id);
}