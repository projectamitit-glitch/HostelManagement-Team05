package com.avsoft.hostelmanagement.serviceImpl;

<<<<<<< HEAD
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
=======
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avsoft.hostelmanagement.entity.Building;
import com.avsoft.hostelmanagement.entity.Floor;
import com.avsoft.hostelmanagement.entity.Hostel;
import com.avsoft.hostelmanagement.repostiory.BuildingRepository;
import com.avsoft.hostelmanagement.repostiory.FloorRepository;
import com.avsoft.hostelmanagement.repostiory.HostelRepository;
import com.avsoft.hostelmanagement.service.BuildingService;

@Service
public class BuildingServiceImpl implements BuildingService {

    @Autowired
    private BuildingRepository buildingRepository;

    @Autowired
    private FloorRepository floorRepository;

    @Autowired
    private HostelRepository hostelRepository;

    @Override
    public Building saveBuilding(Building building, Long hostelId) {

        building.setCreatedAt(LocalDate.now());
        building.setUpdatedAt(LocalDate.now());
        building.setStatus("ACTIVE");

        Hostel hostel = hostelRepository.findById(hostelId).orElseThrow(() -> new RuntimeException("Hostel not found with ID: " + hostelId));

        building.setHostel(hostel);

        Building savedBuilding = buildingRepository.save(building);

        if (building.getFloorsList() != null) {
        	
            for (Floor floor : building.getFloorsList()) {
            	
                floor.setBuilding(savedBuilding);
                
                floorRepository.save(floor);
                
            }
        }

        return savedBuilding;
        
    }

    @Override
    public List<Building> saveAllBuildings(List<Building> buildings, Long hostelId) {

        Hostel hostel = hostelRepository.findById(hostelId)
                .orElseThrow(() -> new RuntimeException("Hostel not found with ID: " + hostelId));

        for (Building b : buildings) {
            b.setHostel(hostel);
            b.setCreatedAt(LocalDate.now());
            b.setUpdatedAt(LocalDate.now());
            b.setStatus("ACTIVE");
        }

        return buildingRepository.saveAll(buildings);
    }

    @Override
    public Building getBuildingById(Long id) {
    	
        return buildingRepository.findById(id).orElseThrow(() -> new RuntimeException("Building not found with ID: " + id));
        
    }
    
    @Override
    public List<Building> getAllBuildings() {
    	
        return buildingRepository.findAll();
        
    }

    @Override
    public List<Building> getBuildingByName(String name) {
    	
        return buildingRepository.findByName(name);
        
    }

}

>>>>>>> remotes/origin/feature/samiksha/#11
