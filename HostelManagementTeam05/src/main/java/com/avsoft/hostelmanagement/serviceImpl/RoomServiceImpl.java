package com.avsoft.hostelmanagement.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avsoft.hostelmanagement.entity.Bed;
import com.avsoft.hostelmanagement.entity.Floor;
import com.avsoft.hostelmanagement.entity.Room;
import com.avsoft.hostelmanagement.repostiory.BedRepository;
import com.avsoft.hostelmanagement.repostiory.FloorRepository;
import com.avsoft.hostelmanagement.repostiory.RoomRepository;
import com.avsoft.hostelmanagement.service.RoomService;

@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private FloorRepository floorRepository;

    @Autowired
    private BedRepository bedRepository;

    @Override
    public Room saveRoom(Room room, Long floorId) {

        Floor floor = floorRepository.findById(floorId).orElseThrow(() -> new RuntimeException("Floor not found with id: " + floorId));

        room.setFloor(floor);

        Room savedRoom = roomRepository.save(room);

        if (room.getBeds() != null) {
        	
            for (Bed bed : room.getBeds()) {
                bed.setRoom(savedRoom);
                bedRepository.save(bed);
                
            }
        }

        return savedRoom;
    }

    @Override
    public List<Room> saveAllRooms(List<Room> rooms, Long floorId) {

        Floor floor = floorRepository.findById(floorId).orElseThrow(() -> new RuntimeException("Floor not found with id: " + floorId));

        for (Room room : rooms) {
            room.setFloor(floor);
        }

        return roomRepository.saveAll(rooms);
        
    }

    @Override
    public Room getRoomById(Long id) {
    	
        return roomRepository.findById(id).orElseThrow(() -> new RuntimeException("Room not found with id: " + id));
        
    }

    @Override
    public List<Room> getAllRooms() {
    	
        return roomRepository.findAll();
        
    }

}

