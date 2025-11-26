package com.avsoft.hostelmanagement.service;

import java.util.List;

import com.avsoft.hostelmanagement.entity.Building;

public interface BuildingService {

    Building saveBuilding(Building building, Long hostelId);

    List<Building> saveAllBuildings(List<Building> buildings, Long hostelId);

    Building getBuildingById(Long id);

    List<Building> getBuildingByName(String name);

    List<Building> getAllBuildings();

}

