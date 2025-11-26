package com.avsoft.hostelmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.avsoft.hostelmanagement.dto.ApiResponse;
import com.avsoft.hostelmanagement.dto.BuildingDto;
import com.avsoft.hostelmanagement.service.BuildingService;

@RestController
@RequestMapping("/api/buildings")
public class BuildingController {

    @Autowired
    private BuildingService buildingService;

    // Create Building
    @PostMapping
    public ResponseEntity<ApiResponse<BuildingDto>> createBuilding(@RequestBody BuildingDto dto) {
        BuildingDto created = buildingService.createBuilding(dto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ApiResponse<>("SUCCESS", "Building Created Successfully", created));
    }

    // Get Building By ID
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<BuildingDto>> getBuildingById(@PathVariable Long id) {
        return ResponseEntity.ok(new ApiResponse<>("SUCCESS", "Building Fetched", buildingService.getBuildingById(id)));
    }

    // Get All Buildings for a specific Hostel (e.g., "Wing A", "Wing B" of Hostel X)
    @GetMapping("/hostel/{hostelId}")
    public ResponseEntity<ApiResponse<List<BuildingDto>>> getBuildingsByHostel(@PathVariable Long hostelId) {
        return ResponseEntity.ok(new ApiResponse<>("SUCCESS", "Hostel Buildings Fetched", buildingService.getBuildingsByHostel(hostelId)));
    }

    // Update
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<BuildingDto>> updateBuilding(@PathVariable Long id, @RequestBody BuildingDto dto) {
        return ResponseEntity.ok(new ApiResponse<>("SUCCESS", "Building Updated", buildingService.updateBuilding(id, dto)));
    }

    // Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<String>> deleteBuilding(@PathVariable Long id) {
        buildingService.deleteBuilding(id);
        return ResponseEntity.ok(new ApiResponse<>("SUCCESS", "Building Deleted", null));
    }
}