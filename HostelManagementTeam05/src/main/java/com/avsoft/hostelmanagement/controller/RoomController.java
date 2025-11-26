package com.avsoft.hostelmanagement.controller;

import com.avsoft.hostelmanagement.dto.ApiResponse;
import com.avsoft.hostelmanagement.dto.RoomDto;
import com.avsoft.hostelmanagement.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rooms")
public class RoomController {

    @Autowired
    private RoomService roomService;

    // Create Room
    @PostMapping
    public ResponseEntity<ApiResponse<RoomDto>> createRoom(@RequestBody RoomDto dto) {
        RoomDto created = roomService.createRoom(dto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ApiResponse<>("SUCCESS", "Room Created Successfully", created));
    }

    // Get Room By ID
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<RoomDto>> getRoomById(@PathVariable Long id) {
        return ResponseEntity.ok(new ApiResponse<>("SUCCESS", "Room Fetched", roomService.getRoomById(id)));
    }

    // Get All Rooms for a specific Floor
    @GetMapping("/floor/{floorId}")
    public ResponseEntity<ApiResponse<List<RoomDto>>> getRoomsByFloor(@PathVariable Long floorId) {
        return ResponseEntity.ok(new ApiResponse<>("SUCCESS", "Floor Rooms Fetched", roomService.getRoomsByFloor(floorId)));
    }

    // Update
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<RoomDto>> updateRoom(@PathVariable Long id, @RequestBody RoomDto dto) {
        return ResponseEntity.ok(new ApiResponse<>("SUCCESS", "Room Updated", roomService.updateRoom(id, dto)));
    }

    // Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<String>> deleteRoom(@PathVariable Long id) {
        roomService.deleteRoom(id);
        return ResponseEntity.ok(new ApiResponse<>("SUCCESS", "Room Deleted", null));
    }
}