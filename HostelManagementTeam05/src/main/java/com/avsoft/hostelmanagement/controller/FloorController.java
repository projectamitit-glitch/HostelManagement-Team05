package com.avsoft.hostelmanagement.controller;

import com.avsoft.hostelmanagement.dto.ApiResponse;
import com.avsoft.hostelmanagement.dto.FloorDto;
import com.avsoft.hostelmanagement.service.FloorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/floors")
public class FloorController {

    @Autowired
    private FloorService floorService;

    // Create Floor
    @PostMapping
    public ResponseEntity<ApiResponse<FloorDto>> createFloor(@RequestBody FloorDto dto) {
        FloorDto created = floorService.createFloor(dto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ApiResponse<>("SUCCESS", "Floor Created Successfully", created));
    }

    // Get Floor By ID
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<FloorDto>> getFloorById(@PathVariable Long id) {
        return ResponseEntity.ok(new ApiResponse<>("SUCCESS", "Floor Fetched", floorService.getFloorById(id)));
    }

    // Get All Floors for a specific Building
    @GetMapping("/building/{buildingId}")
    public ResponseEntity<ApiResponse<List<FloorDto>>> getFloorsByBuilding(@PathVariable Long buildingId) {
        return ResponseEntity.ok(new ApiResponse<>("SUCCESS", "Building Floors Fetched", floorService.getFloorsByBuilding(buildingId)));
    }

    // Update
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<FloorDto>> updateFloor(@PathVariable Long id, @RequestBody FloorDto dto) {
        return ResponseEntity.ok(new ApiResponse<>("SUCCESS", "Floor Updated", floorService.updateFloor(id, dto)));
    }

    // Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<String>> deleteFloor(@PathVariable Long id) {
        floorService.deleteFloor(id);
        return ResponseEntity.ok(new ApiResponse<>("SUCCESS", "Floor Deleted", null));
    }
}