package com.avsoft.hostelmanagement.service;

import java.util.List;

import com.avsoft.hostelmanagement.entity.Floor;

public interface FloorService {

    Floor saveFloor(Floor floor, Long buildingId);

    List<Floor> saveAllFloors(List<Floor> floors, Long buildingId);

    Floor getFloorById(Long id);

    List<Floor> getAllFloors();

    List<Floor> getFloorByRoomCount(int noOfRooms);
}

