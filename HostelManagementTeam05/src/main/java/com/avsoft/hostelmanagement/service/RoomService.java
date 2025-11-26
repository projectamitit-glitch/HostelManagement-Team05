package com.avsoft.hostelmanagement.service;

import com.avsoft.hostelmanagement.dto.RoomDto;
import java.util.List;

public interface RoomService {

    RoomDto createRoom(RoomDto dto);

    RoomDto getRoomById(Long id);

    List<RoomDto> getAllRooms();

    List<RoomDto> getRoomsByFloor(Long floorId);

    RoomDto updateRoom(Long id, RoomDto dto);

    void deleteRoom(Long id);
}