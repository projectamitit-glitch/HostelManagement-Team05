package com.avsoft.hostelmanagement.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.avsoft.hostelmanagement.util.MessageConstant;
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


}
