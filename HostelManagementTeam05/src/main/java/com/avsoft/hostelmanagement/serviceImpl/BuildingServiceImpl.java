package com.avsoft.hostelmanagement.serviceImpl;

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

