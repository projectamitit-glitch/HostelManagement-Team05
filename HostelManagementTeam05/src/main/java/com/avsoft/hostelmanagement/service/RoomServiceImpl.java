package com.avsoft.hostelmanagement.service;

import com.avsoft.hostelmanagement.dto.RoomDto;
import com.avsoft.hostelmanagement.entity.Floor;
import com.avsoft.hostelmanagement.entity.Room;
import com.avsoft.hostelmanagement.exceptionHandler.HostelServiceExceptionHandler;
import com.avsoft.hostelmanagement.repostiory.FloorRepository;
import com.avsoft.hostelmanagement.repostiory.RoomRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private FloorRepository floorRepository;

    @Override
    public RoomDto createRoom(RoomDto dto) {
        // 1. Validate Parent (Floor)
        Floor floor = floorRepository.findById(dto.getFloorId())
                .orElseThrow(() -> new HostelServiceExceptionHandler("Floor not found with id: " + dto.getFloorId(),HttpStatus.NOT_FOUND));

        // 2. Map DTO -> Entity
        Room room = new Room();
        BeanUtils.copyProperties(dto, room);

        // 3. Set Relations
        room.setFloor(floor);
        if (room.getStatus() == null) room.setStatus("AVAILABLE");

        Room savedRoom = roomRepository.save(room);

        // 4. Map Entity -> DTO
        return mapToDto(savedRoom);
    }

    @Override
    public RoomDto getRoomById(Long id) {
        Room room = roomRepository.findById(id)
                .orElseThrow(() -> new HostelServiceExceptionHandler("Room not found with id: " + id,HttpStatus.NOT_FOUND));
        return mapToDto(room);
    }

    @Override
    public List<RoomDto> getAllRooms() {
        return roomRepository.findAll().stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<RoomDto> getRoomsByFloor(Long floorId) {
        return roomRepository.findByFloorId(floorId).stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public RoomDto updateRoom(Long id, RoomDto dto) {
        Room existing = roomRepository.findById(id)
                .orElseThrow(() -> new HostelServiceExceptionHandler("Room not found with id: " + id,HttpStatus.NOT_FOUND));

        // Update fields
        existing.setRoomNo(dto.getRoomNo());
        existing.setType(dto.getType());
        existing.setPricePerBed(dto.getPricePerBed());
        existing.setStatus(dto.getStatus());
        if (dto.getAttachedBathroom() != null) {
            existing.setAttachedBathroom(dto.getAttachedBathroom());
        } 
        
        if (dto.getBalcony() != null) {
            existing.setBalcony(dto.getBalcony());
        }

        Room updated = roomRepository.save(existing);
        return mapToDto(updated);
    }

    @Override
    public void deleteRoom(Long id) {
        if (!roomRepository.existsById(id)) {
        	throw new HostelServiceExceptionHandler("Room not found with id: " + id, HttpStatus.NOT_FOUND);
        }
        roomRepository.deleteById(id);
    }

    // Helper: Map Entity to DTO
    private RoomDto mapToDto(Room room) {
        RoomDto dto = new RoomDto();
        BeanUtils.copyProperties(room, dto);

        // Manual mapping for Parent ID
        if (room.getFloor() != null) {
            dto.setFloorId(room.getFloor().getId());
        }
        return dto;
    }
}