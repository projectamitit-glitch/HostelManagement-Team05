package com.avsoft.hostelmanagement.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.avsoft.hostelmanagement.dto.RoomDto;
import com.avsoft.hostelmanagement.entity.Floor;
import com.avsoft.hostelmanagement.entity.Room;
import com.avsoft.hostelmanagement.exceptionHandler.FloorServiceException;
import com.avsoft.hostelmanagement.exceptionHandler.RoomServiceException;
import com.avsoft.hostelmanagement.repostiory.FloorRepository;
import com.avsoft.hostelmanagement.repostiory.RoomRepository;
import com.avsoft.hostelmanagement.service.RoomService;

@Service
public class RoomServiceImpl implements RoomService {
	
	@Autowired
	RoomRepository roomRepository;
	
	@Autowired
	FloorRepository floorRepository;

	@Override
	public RoomDto createRoom(RoomDto dto) {
		
		Floor floor = floorRepository.findById(dto.getFloorId())
                .orElseThrow(() -> new RoomServiceException("Floor not found with id: " + dto.getFloorId(),HttpStatus.NOT_FOUND));
		
		Room room = new Room();
		BeanUtils.copyProperties(dto, room);
		
		room.setFloor(floor);
		
		if(room.getStatus() == null || room.getStatus().isEmpty()) {
			room.setStatus("AVAILABLE");
		}
		
		Room savedRoom = roomRepository.save(room);
		return mapToDto(savedRoom);
		
	}

	@Override
	public RoomDto getRoomById(Long id) {
		
		Room room = roomRepository.findById(id).orElseThrow(() -> new RoomServiceException("Room not found with id: " + id,HttpStatus.NOT_FOUND));
		
		return mapToDto(room);
		
	}

	@Override
	public List<RoomDto> getAllRooms() {
		// TODO Auto-generated method stub
		return roomRepository.findAll().stream()
				.map(this::mapToDto)
				.collect(Collectors.toList());
	}

	@Override
	public List<RoomDto> getRoomsByFloor(Long floorId) {
	
		if(!floorRepository.existsById(floorId)) {
			throw new FloorServiceException("Floor not found with id: " + floorId, HttpStatus.NOT_FOUND);
		}
		
		return roomRepository.findByFloorId(floorId).stream().map(this::mapToDto).collect(Collectors.toList());
		
	}

	@Override
	public RoomDto updateRoom(Long id, RoomDto dto) {
		Room existing = roomRepository.findById(id).orElseThrow(()-> new RoomServiceException("Room not found with id: " + id, HttpStatus.NOT_FOUND));
		
		if(dto.getRoomNo() !=0) existing.setRoomNo(dto.getRoomNo());
		if(dto.getType() != null) existing.setType(dto.getType());
		if(dto.getPricePerBed() !=null) existing.setPricePerBed(dto.getPricePerBed());
		if(dto.getStatus() !=null) existing.setStatus(dto.getStatus());
		if(dto.getAttachedBathroom() != null) existing.setAttachedBathroom(dto.getAttachedBathroom());
		if(dto.getBalcony() !=null) existing.setBalcony(dto.getBalcony());
		
		Room updatedRoom = roomRepository.save(existing);
		return mapToDto(updatedRoom);
		
	}

	@Override
	public void deleteRoom(Long id) {
		
		if(!roomRepository.existsById(id)) {
			throw new RoomServiceException("Room not found with id: " + id, HttpStatus.NOT_FOUND);
		}
		
		roomRepository.deleteById(id);
		
	}
	
	// Helper Method
    private RoomDto mapToDto(Room room) {
    	
        RoomDto dto = new RoomDto();
        BeanUtils.copyProperties(room, dto);
        
        if (room.getFloor() != null) {
            dto.setFloorId(room.getFloor().getId());
        }
        
        return dto;
    }

}
