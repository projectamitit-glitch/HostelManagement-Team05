package com.avsoft.hostelmanagement.controller;

import com.avsoft.hostelmanagement.dto.ApiResponse;
import com.avsoft.hostelmanagement.dto.BedDto;
import com.avsoft.hostelmanagement.service.BedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/beds")
public class BedController {

    @Autowired
    private BedService bedService;

    // Create Bed
    @PostMapping
    public ResponseEntity<ApiResponse<BedDto>> createBed(@RequestBody BedDto dto) {
        BedDto created = bedService.createBed(dto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ApiResponse<>("SUCCESS", "Bed Created Successfully", created));
    }

    // Get Bed By ID
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<BedDto>> getBedById(@PathVariable Long id) {
        return ResponseEntity.ok(new ApiResponse<>("SUCCESS", "Bed Fetched", bedService.getBedById(id)));
    }

    // Get All Beds in a specific Room
    @GetMapping("/room/{roomId}")
    public ResponseEntity<ApiResponse<List<BedDto>>> getBedsByRoom(@PathVariable Long roomId) {
        return ResponseEntity.ok(new ApiResponse<>("SUCCESS", "Room Beds Fetched", bedService.getBedsByRoom(roomId)));
    }

    // Update
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<BedDto>> updateBed(@PathVariable Long id, @RequestBody BedDto dto) {
        return ResponseEntity.ok(new ApiResponse<>("SUCCESS", "Bed Updated", bedService.updateBed(id, dto)));
    }

    // Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<String>> deleteBed(@PathVariable Long id) {
        bedService.deleteBed(id);
        return ResponseEntity.ok(new ApiResponse<>("SUCCESS", "Bed Deleted", null));
    }
}