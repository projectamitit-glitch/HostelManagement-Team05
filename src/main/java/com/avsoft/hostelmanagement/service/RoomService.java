package com.avsoft.hostelmanagement.service;

import java.util.List;

import com.avsoft.hostelmanagement.dto.RoomDto;
import com.avsoft.hostelmanagement.entity.Room;

public interface RoomService {
    RoomDto createRoom(RoomDto dto);
    List<Room> saveRooms(List<RoomDto> roomDto);
    RoomDto getRoomById(Long id);
    List<RoomDto> getAllRooms();
    List<RoomDto> getRoomsByFloor(Long floorId);
    RoomDto updateRoom(Long id, RoomDto dto);
    void deleteRoom(Long id);
}
