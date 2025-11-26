package com.avsoft.hostelmanagement.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avsoft.hostelmanagement.entity.Building;
import com.avsoft.hostelmanagement.entity.Floor;
import com.avsoft.hostelmanagement.entity.Room;
import com.avsoft.hostelmanagement.repostiory.BuildingRepository;
import com.avsoft.hostelmanagement.repostiory.FloorRepository;
import com.avsoft.hostelmanagement.service.FloorService;

@Service
public class FloorServiceImpl implements FloorService {

    @Autowired
    private FloorRepository floorRepository;

    @Autowired
    private BuildingRepository buildingRepository;

    @Override
    public Floor saveFloor(Floor floor, Long buildingId) {

        Building building = buildingRepository.findById(buildingId).orElseThrow(() -> new RuntimeException("Building not found with id: " + buildingId));

        floor.setBuilding(building);

        if (floor.getRooms() != null) {
            for (Room r : floor.getRooms()) {
                r.setFloor(floor);
            }
        }

        return floorRepository.save(floor);
        
    }

    @Override
    public List<Floor> saveAllFloors(List<Floor> floors, Long buildingId) {

        Building building = buildingRepository.findById(buildingId).orElseThrow(() -> new RuntimeException("Building not found with id: " + buildingId));

        for (Floor floor : floors) {
            floor.setBuilding(building);

            if (floor.getRooms() != null) {
                for (Room room : floor.getRooms()) {
                    room.setFloor(floor);
                }
            }
        }

        return floorRepository.saveAll(floors);
        
    }

    @Override
    public Floor getFloorById(Long id) {
    	
        return floorRepository.findById(id).orElseThrow(() -> new RuntimeException("Floor not found with id: " + id));
        
    }

    @Override
    public List<Floor> getAllFloors() {
    	
        return floorRepository.findAll();
        
    }

    @Override
    public List<Floor> getFloorByRoomCount(int noOfRooms) {
    	
        return floorRepository.findByNoOfRooms(noOfRooms);
        
    }

}

