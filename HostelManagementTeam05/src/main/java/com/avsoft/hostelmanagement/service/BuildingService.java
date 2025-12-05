package com.avsoft.hostelmanagement.service;

import java.util.List;

<<<<<<< HEAD
import com.avsoft.hostelmanagement.dto.BuildingDto;
=======
>>>>>>> remotes/origin/feature/samiksha/#11
import com.avsoft.hostelmanagement.entity.Building;

public interface BuildingService {
	
	
	Building saveBuilding(Long hostelId,BuildingDto dto);
	
	Building getBuildingById(Long id);
	
	List<Building> getAllBuilding();
	
	void deleteBuilding(Long id);
	
	void deleteAllBuilding();

    Building saveBuilding(Building building, Long hostelId);

    List<Building> saveAllBuildings(List<Building> buildings, Long hostelId);

    Building getBuildingById(Long id);

    List<Building> getBuildingByName(String name);

    List<Building> getAllBuildings();

}

