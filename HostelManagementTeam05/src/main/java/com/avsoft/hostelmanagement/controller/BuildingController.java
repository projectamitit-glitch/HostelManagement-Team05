package com.avsoft.hostelmanagement.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.avsoft.hostelmanagement.dto.BuildingDto;
import com.avsoft.hostelmanagement.entity.Building;
import com.avsoft.hostelmanagement.service.BuildingService;

@RestController
@RequestMapping("/building")
public class BuildingController {

    @Autowired
    BuildingService buildingService;

    @PostMapping("/save/{hostelId}")
    public ResponseEntity<Building> saveBuilding(@PathVariable Long hostelId,@ RequestBody BuildingDto dto){
                                                

        Building saved = buildingService.saveBuilding(hostelId, dto);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Building> getBuilding(@PathVariable Long id) {
        return new ResponseEntity<>(buildingService.getBuildingById(id), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Building>> getAll() {
        return new ResponseEntity<>(buildingService.getAllBuilding(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        buildingService.deleteBuilding(id);
        return new ResponseEntity<>("Building deleted successfully", HttpStatus.OK);
    }

    @DeleteMapping("/deleteAll")
    public ResponseEntity<String> deleteAll() {
        buildingService.deleteAllBuilding();
        return new ResponseEntity<>("All buildings deleted successfully", HttpStatus.OK);
    }

}
