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
import com.avsoft.hostelmanagement.dto.HostelDto;
import com.avsoft.hostelmanagement.service.HostelService;
import com.avsoft.hostelmanagement.service.HostelServiceImpl;

@RestController
@RequestMapping("/api/hostels")
public class HostelController {

    @Autowired
    private HostelServiceImpl hostelServiceImpl ;

    @PostMapping
    public ResponseEntity<ApiResponse<HostelDto>> createHostel(@RequestBody HostelDto dto) {
        HostelDto created = hostelServiceImpl.createHostel(dto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ApiResponse<>("SUCCESS", "Hostel Created Successfully", created));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<HostelDto>> getHostelById(@PathVariable Long id) {
        return ResponseEntity.ok(new ApiResponse<>("SUCCESS", "Hostel Fetched", hostelServiceImpl.getHostelById(id)));
    }

    // Get all hostels in the database
    @GetMapping
    public ResponseEntity<ApiResponse<List<HostelDto>>> getAllHostels() {
        return ResponseEntity.ok(new ApiResponse<>("SUCCESS", "All Hostels Fetched", hostelServiceImpl.getAllHostels()));
    }
    
    // Get all hostels for a specific Organization (e.g., all branches of AV Soft)
    @GetMapping("/organization/{orgId}")
    public ResponseEntity<ApiResponse<List<HostelDto>>> getHostelsByOrg(@PathVariable Long orgId) {
        return ResponseEntity.ok(new ApiResponse<>("SUCCESS", "Organization Hostels Fetched", hostelServiceImpl.getHostelsByOrganization(orgId)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<HostelDto>> updateHostel(@PathVariable Long id, @RequestBody HostelDto dto) {
        return ResponseEntity.ok(new ApiResponse<>("SUCCESS", "Hostel Updated", hostelServiceImpl.updateHostel(id, dto)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<String>> deleteHostel(@PathVariable Long id) {
        hostelServiceImpl.deleteHostel(id);
        return ResponseEntity.ok(new ApiResponse<>("SUCCESS", "Hostel Deleted", null));
    }
}
