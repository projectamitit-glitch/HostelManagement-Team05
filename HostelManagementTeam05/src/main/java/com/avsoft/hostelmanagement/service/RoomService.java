package com.avsoft.hostelmanagement.service;

import java.util.List;

import com.avsoft.hostelmanagement.dto.RoomDto;

public interface RoomService {
	RoomDto createRoom(RoomDto dto);

	RoomDto getRoomById(Long id);

	List<RoomDto> getAllRooms();

	List<RoomDto> getRoomsByFloor(Long floorId);

	RoomDto updateRoom(Long id, RoomDto dto);

	void deleteRoom(Long id);
}
