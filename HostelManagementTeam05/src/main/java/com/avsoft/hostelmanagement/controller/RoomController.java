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

import com.avsoft.hostelmanagement.MessageConstant.MessageConstant;
import com.avsoft.hostelmanagement.dto.FloorDto;
import com.avsoft.hostelmanagement.dto.RoomDto;
import com.avsoft.hostelmanagement.response.ApiResponse;
import com.avsoft.hostelmanagement.service.RoomService;

@RestController
@RequestMapping("/api/rooms")
public class RoomController {
	
	@Autowired 
	RoomService roomService;
	
	@PostMapping
	public ResponseEntity<ApiResponse<RoomDto>> createRoom(@RequestBody RoomDto roomDto){
		RoomDto createdRoomDto = roomService.createRoom(roomDto);
		return new ResponseEntity<>(
				new ApiResponse<>(MessageConstant.ROOM_CREATED_SUCCESS,createdRoomDto),HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ApiResponse<RoomDto>> getRommById(@PathVariable Long id){
		RoomDto roomDto = roomService.getRoomById(id);
		return new ResponseEntity<>(new ApiResponse<>(MessageConstant.ROOM_FETCH_SUCCESS,roomDto),HttpStatus.OK);
	}
	
	@GetMapping("/floor/{floorId}")
	public ResponseEntity<ApiResponse<List<RoomDto>>> getRoomsByFloor(@PathVariable Long id){
		List<RoomDto> listRooms = roomService.getRoomsByFloor(id);
		return new ResponseEntity<>(
				new ApiResponse<>(MessageConstant.ROOM_LIST_FETCH_SUCCESS,listRooms),HttpStatus.OK
				);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ApiResponse<RoomDto>> updateRoom(@RequestBody RoomDto dto, @PathVariable long id){
		RoomDto updatedRoom = roomService.updateRoom(id, dto);
		return new ResponseEntity<>(
				new ApiResponse<>(MessageConstant.ROOM_UPDATE_SUCCESS,updatedRoom),HttpStatus.OK
				);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ApiResponse<String>> deleteRoom(@PathVariable long id){
		roomService.deleteRoom(id);
		return new ResponseEntity<>(new ApiResponse<>(MessageConstant.ROOM_DELETE_SUCCESS,null),HttpStatus.OK);
	}
}
