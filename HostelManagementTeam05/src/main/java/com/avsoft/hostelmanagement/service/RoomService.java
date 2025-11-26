package com.avsoft.hostelmanagement.service;

import java.util.List;

import com.avsoft.hostelmanagement.entity.Room;

public interface RoomService {

    Room saveRoom(Room room, Long floorId);

    List<Room> saveAllRooms(List<Room> rooms, Long floorId);

    Room getRoomById(Long id);

    List<Room> getAllRooms();
}

