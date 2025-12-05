package com.avsoft.hostelmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
<<<<<<< HEAD
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
=======
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
>>>>>>> remotes/origin/feature/samiksha/#11
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

<<<<<<< HEAD
import com.avsoft.hostelmanagement.dto.BuildingDto;
import com.avsoft.hostelmanagement.dto.RoomDto;
import com.avsoft.hostelmanagement.entity.Bed;
import com.avsoft.hostelmanagement.entity.Building;
import com.avsoft.hostelmanagement.response.ApiResponse;
import com.avsoft.hostelmanagement.service.RoomService;
import com.avsoft.hostelmanagement.util.MessageConstant;

@RestController
@RequestMapping("/rooms")
public class RoomController {
	
	@Autowired 
	RoomService roomService;
	
	@PostMapping("/room")
	public ResponseEntity<ApiResponse<RoomDto>> createRoom(@RequestBody RoomDto roomDto){
		
		RoomDto createdRoomDto = roomService.createRoom(roomDto);
		
		return new ResponseEntity<>(new ApiResponse<>(MessageConstant.ROOM_CREATED_SUCCESS,createdRoomDto),HttpStatus.CREATED);
		
	}
	
	@GetMapping("/room/{id}")
	public ResponseEntity<ApiResponse<RoomDto>> getRommById(@PathVariable Long id){
		
		RoomDto roomDto = roomService.getRoomById(id);
		
		return new ResponseEntity<>(new ApiResponse<>(MessageConstant.ROOM_FETCH_SUCCESS,roomDto),HttpStatus.OK);
		
	}
	
	@GetMapping("/room/{floorId}")
	public ResponseEntity<ApiResponse<List<RoomDto>>> getRoomsByFloor(@PathVariable Long id){
		
		List<RoomDto> listRooms = roomService.getRoomsByFloor(id);
		
		return new ResponseEntity<>(new ApiResponse<>(MessageConstant.ROOM_LIST_FETCH_SUCCESS,listRooms),HttpStatus.OK);
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ApiResponse<RoomDto>> updateRoom(@RequestBody RoomDto dto, @PathVariable long id){
		
		RoomDto updatedRoom = roomService.updateRoom(id, dto);
		
		return new ResponseEntity<>(new ApiResponse<>(MessageConstant.ROOM_UPDATE_SUCCESS,updatedRoom),HttpStatus.OK);
		
	}
	
	@DeleteMapping("/{roomId}")
	public ResponseEntity<ApiResponse<String>> deleteRoom(@PathVariable long id){
		
		roomService.deleteRoom(id);
		
		return new ResponseEntity<>(new ApiResponse<>(MessageConstant.ROOM_DELETE_SUCCESS,null),HttpStatus.OK);
		
	}
=======
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
>>>>>>> remotes/origin/feature/samiksha/#11
}
