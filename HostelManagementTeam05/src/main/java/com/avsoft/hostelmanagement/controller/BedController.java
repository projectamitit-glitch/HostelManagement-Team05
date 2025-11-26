package com.avsoft.hostelmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.avsoft.hostelmanagement.entity.Bed;
import com.avsoft.hostelmanagement.service.BedService;

@RestController
@RequestMapping("/beds")
public class BedController {

    @Autowired
    private BedService bedService;

    @PostMapping("/add/{roomId}")
    public ResponseEntity<Bed> addBed(@RequestBody Bed bed, @PathVariable Long roomId) {

        Bed saved = bedService.saveBed(bed, roomId);
        
        return ResponseEntity.ok(saved);
        
    }

    @PostMapping("/addAll/{roomId}")
    public ResponseEntity<List<Bed>> addAllBeds(@RequestBody List<Bed> beds, @PathVariable Long roomId) {

        List<Bed> saved = bedService.saveAllBeds(beds, roomId);
        
        return ResponseEntity.ok(saved);
        
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bed> getBed(@PathVariable Long id) {
    	
        return ResponseEntity.ok(bedService.getBedById(id));
        
    }

    @GetMapping("/available")
    public ResponseEntity<List<Bed>> getAvailable(@RequestParam int sharing, @RequestParam String status) {

        return ResponseEntity.ok(bedService.getAvailableBedsBySharing(sharing, status));
        
    }

    @GetMapping("/vacant")
    public ResponseEntity<List<Bed>> getVacantBeds(@RequestParam int sharing, @RequestParam Long hostelId) {

        return ResponseEntity.ok(bedService.getVacantBedBySharingAndHostel(sharing, hostelId));
        
    }

}

