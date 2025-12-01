package com.avsoft.hostelmanagement.serviceImpl;

import java.util.List;

import org.hibernate.property.access.spi.PropertyAccessBuildingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.avsoft.hostelmanagement.dto.BuildingDto;
import com.avsoft.hostelmanagement.entity.Building;
import com.avsoft.hostelmanagement.entity.Hostel;
import com.avsoft.hostelmanagement.exceptionHandler.BuildingException;
import com.avsoft.hostelmanagement.repostiory.BuildingRepository;
import com.avsoft.hostelmanagement.repostiory.HostelRepository;
import com.avsoft.hostelmanagement.service.BuildingService;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Service
public class BuildingServiceImpl implements BuildingService{

	@Autowired
	BuildingRepository buildingRepository;
	
	@Autowired
	HostelRepository hostelRepository;
	
	
	@Override
	public Building saveBuilding(Long hostelId, BuildingDto dto) {
		
		
		log.info("saving building for Hostel ID:", hostelId);
		
		Hostel hostel = hostelRepository.findById(hostelId).orElse(null);
		
		if (hostel == null) {
			
			throw new RuntimeException("hostel not found");
		}
		
		
		
		Building building = new Building();
		building.setName(dto.getName());
		building.setFloors(dto.getFloors());
		building.setWarden(dto.getWarden());
		building.setMaintenanceRequired(dto.isMaintenanceRequired());
		
		
		building.setHostel(hostel);
		
		return buildingRepository.save(building);
		
		
		
		
	}
	
	

	@Override
	public Building getBuildingById(Long id) {
	
		
		Building building = buildingRepository.findById(id).orElse(null);
		
		if (building == null) {
			
			throw new BuildingException("Building not found by this id:"+ id, HttpStatus.NOT_FOUND);
			
			
			
		}
		
		return building;
	}
	
	

	@Override
	public List<Building> getAllBuilding() {
		
		log.info("Featching all buildings");
		
		return buildingRepository.findAll();
	}

	
	
	@Override
	public void deleteBuilding(Long id) {

		Building building = buildingRepository.findById(id).orElse(null);
		
		
		if (building == null) {
			throw new BuildingException("Building isnot found with id: " + id, HttpStatus.NOT_FOUND);
		}

		buildingRepository.delete(building);

	}

	@Override
	public void deleteAllBuilding() {

		buildingRepository.deleteAll();

	}

}
