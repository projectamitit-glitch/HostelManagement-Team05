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

import com.avsoft.hostelmanagement.entity.Floor;
import com.avsoft.hostelmanagement.service.FloorService;

@RestController
@RequestMapping("/floor")
public class FloorController {

    @Autowired
    private FloorService floorService;

    @PostMapping("/add/{buildingId}")
    public ResponseEntity<Floor> addFloor(@RequestBody Floor floor, @PathVariable Long buildingId) {
    	
        return ResponseEntity.ok(floorService.saveFloor(floor, buildingId));
        
    }

    @PostMapping("/add-multiple/{buildingId}")
    public ResponseEntity<List<Floor>> addFloors(@RequestBody List<Floor> floors, @PathVariable Long buildingId) {
    	
        return ResponseEntity.ok(floorService.saveAllFloors(floors, buildingId));
        
    }

    @GetMapping("/{id}")
    public ResponseEntity<Floor> getFloor(@PathVariable Long id) {
    	
        return ResponseEntity.ok(floorService.getFloorById(id));
        
    }

    @GetMapping("/all")
    public ResponseEntity<List<Floor>> getAll() {
    	
        return ResponseEntity.ok(floorService.getAllFloors());
        
    }

    @GetMapping("/rooms/{count}")
    public ResponseEntity<List<Floor>> getFloorsByRooms(@PathVariable int count) {
    	
        return ResponseEntity.ok(floorService.getFloorByRoomCount(count));
        
    }
}
