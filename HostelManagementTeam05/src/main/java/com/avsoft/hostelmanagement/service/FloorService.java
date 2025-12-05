package com.avsoft.hostelmanagement.service;

import java.util.List;
<<<<<<< HEAD

import com.avsoft.hostelmanagement.dto.FloorDto;
import com.avsoft.hostelmanagement.dto.GetFloorDto;

public interface FloorService {
	
    void addFloor(Long buildingId, FloorDto floorDto);

    FloorDto getFloorById(Long id);

    List<FloorDto> getFloorByBuildingId(Long buildingId);

    List<FloorDto> getAllFloors();

    void deleteFloorById(Long floorId);
=======

import com.avsoft.hostelmanagement.entity.Floor;

public interface FloorService {

    Floor saveFloor(Floor floor, Long buildingId);

    List<Floor> saveAllFloors(List<Floor> floors, Long buildingId);

    Floor getFloorById(Long id);

    List<Floor> getAllFloors();

    List<Floor> getFloorByRoomCount(int noOfRooms);
>>>>>>> remotes/origin/feature/samiksha/#11
}

