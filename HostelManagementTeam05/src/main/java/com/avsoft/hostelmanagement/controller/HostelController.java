package com.avsoft.hostelmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.avsoft.hostelmanagement.entity.Hostel;
import com.avsoft.hostelmanagement.service.HostelService;

@RestController
@RequestMapping("/hostels")
public class HostelController {

    @Autowired
    private HostelService hostelService;

    @PostMapping("/add/{orgId}")
    public ResponseEntity<Hostel> addHostel(@RequestBody Hostel hostel, @PathVariable Long orgId) {

        Hostel saved = hostelService.saveHostel(hostel, orgId);
        return ResponseEntity.ok(saved);
        
    }

    @PostMapping("/add-multiple/{orgId}")
    public ResponseEntity<List<Hostel>> addMultiple(@RequestBody List<Hostel> hostels, @PathVariable Long orgId) {

        return ResponseEntity.ok(hostelService.saveAllHostels(hostels, orgId));
        
    }

    @GetMapping("/{id}")
    public ResponseEntity<Hostel> getHostel(@PathVariable Long id) {
    	
        return ResponseEntity.ok(hostelService.getHostelById(id));
        
    }

    @GetMapping("/all")
    public ResponseEntity<List<Hostel>> getAll() {
    	
        return ResponseEntity.ok(hostelService.getAllHostels());
        
    }
}

