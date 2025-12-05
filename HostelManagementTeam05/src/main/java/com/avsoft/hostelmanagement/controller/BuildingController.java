package com.avsoft.hostelmanagement.controller;

<<<<<<< HEAD

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.avsoft.hostelmanagement.util.MessageConstant;
import com.avsoft.hostelmanagement.dto.BuildingDto;
import com.avsoft.hostelmanagement.entity.Building;
import com.avsoft.hostelmanagement.response.ApiResponse;
=======
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
>>>>>>> remotes/origin/feature/samiksha/#11
import com.avsoft.hostelmanagement.service.BuildingService;

@RestController
@RequestMapping("/building")
public class BuildingController {

    @Autowired
<<<<<<< HEAD
    BuildingService buildingService;

    @PostMapping("/save/{hostelId}")
    public ResponseEntity<ApiResponse<Building>> saveBuilding(@PathVariable Long hostelId, @RequestBody BuildingDto dto){

        Building saved = buildingService.saveBuilding(hostelId, dto);
        return new ResponseEntity<>(
                new ApiResponse<>(MessageConstant.BUILDING_CREATED_SUCCESS, saved),
                HttpStatus.CREATED
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Building>> getBuilding(@PathVariable Long id) {
        Building b = buildingService.getBuildingById(id);
        return new ResponseEntity<>(
                new ApiResponse<>(MessageConstant.BUILDING_FETCH_SUCCESS, b),
                HttpStatus.OK
        );
    }

    @GetMapping("/all")
    public ResponseEntity<ApiResponse<List<Building>>> getAll() {
        List<Building> list = buildingService.getAllBuilding();
        return new ResponseEntity<>(
                new ApiResponse<>(MessageConstant.BUILDING_LIST_FETCH_SUCCESS, list),
                HttpStatus.OK
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<String>> deleteById(@PathVariable Long id) {
        buildingService.deleteBuilding(id);
        return new ResponseEntity<>(
                new ApiResponse<>(MessageConstant.BUILDING_DELETE_SUCCESS, null),
                HttpStatus.OK
        );
    }

    @DeleteMapping("/deleteAll")
    public ResponseEntity<ApiResponse<String>> deleteAll() {
        buildingService.deleteAllBuilding();
        return new ResponseEntity<>(
                new ApiResponse<>(MessageConstant.BUILDING_DELETE_ALL_SUCCESS, null),
                HttpStatus.OK
        );
    }

}
=======
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

>>>>>>> remotes/origin/feature/samiksha/#11
