package com.avsoft.hostelmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.avsoft.hostelmanagement.entity.Building;
import com.avsoft.hostelmanagement.service.BuildingService;

@RestController
@RequestMapping("/building")
public class BuildingController {

    @Autowired
    private BuildingService buildingService;

    @PostMapping("/add/{hostelId}")
    public ResponseEntity<Building> addBuilding(@RequestBody Building building, @PathVariable Long hostelId) {

        return ResponseEntity.ok(buildingService.saveBuilding(building, hostelId));
        
    }

    @PostMapping("/add-all/{hostelId}")
    public ResponseEntity<List<Building>> addAllBuildings(@RequestBody List<Building> buildings, @PathVariable Long hostelId) {

        return ResponseEntity.ok(buildingService.saveAllBuildings(buildings, hostelId));
        
    }

    @GetMapping("/{id}")
    public ResponseEntity<Building> getById(@PathVariable Long id) {
    	
        return ResponseEntity.ok(buildingService.getBuildingById(id));
        
    }
    
    @GetMapping("/all")
    public ResponseEntity<List<Building>> getAll() {
    	
        return ResponseEntity.ok(buildingService.getAllBuildings());
        
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<Building>> getByName(@PathVariable String name) {
    	
        return ResponseEntity.ok(buildingService.getBuildingByName(name));
        
    }
    
}

