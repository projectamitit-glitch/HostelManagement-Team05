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

import com.avsoft.hostelmanagement.entity.Room;
import com.avsoft.hostelmanagement.service.RoomService;

@RestController
@RequestMapping("/room")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @PostMapping("/add/{floorId}")
    public ResponseEntity<Room> addRoom(@RequestBody Room room, @PathVariable Long floorId) {

        return ResponseEntity.ok(roomService.saveRoom(room, floorId));
        
    }

    @PostMapping("/add-all/{floorId}")
    public ResponseEntity<List<Room>> addRooms(@RequestBody List<Room> rooms, @PathVariable Long floorId) {

        return ResponseEntity.ok(roomService.saveAllRooms(rooms, floorId));
        
    }

    @GetMapping("/{id}")
    public ResponseEntity<Room> getRoom(@PathVariable Long id) {
    	
        return ResponseEntity.ok(roomService.getRoomById(id));
        
    }

    @GetMapping("/all")
    public ResponseEntity<List<Room>> getAllRooms() {
    	
        return ResponseEntity.ok(roomService.getAllRooms());
        
    }
}
