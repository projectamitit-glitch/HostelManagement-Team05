package com.avsoft.hostelmanagement.service;

import java.util.List;
<<<<<<< HEAD

import com.avsoft.hostelmanagement.dto.RoomDto;

public interface RoomService {
    RoomDto createRoom(RoomDto dto);
    RoomDto getRoomById(Long id);
    List<RoomDto> getAllRooms();
    List<RoomDto> getRoomsByFloor(Long floorId);
    RoomDto updateRoom(Long id, RoomDto dto);
    void deleteRoom(Long id);
=======

import com.avsoft.hostelmanagement.entity.Room;

public interface RoomService {

    Room saveRoom(Room room, Long floorId);

    List<Room> saveAllRooms(List<Room> rooms, Long floorId);

    Room getRoomById(Long id);

    List<Room> getAllRooms();
>>>>>>> remotes/origin/feature/samiksha/#11
}

