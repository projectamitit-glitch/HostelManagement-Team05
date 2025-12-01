package com.avsoft.hostelmanagement.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.avsoft.hostelmanagement.MessageConstant.MessageConstant;
import com.avsoft.hostelmanagement.dto.BuildingDto;
import com.avsoft.hostelmanagement.entity.Building;
import com.avsoft.hostelmanagement.response.ApiResponse;
import com.avsoft.hostelmanagement.service.BuildingService;

@RestController
@RequestMapping("/building")
public class BuildingController {

    @Autowired
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
