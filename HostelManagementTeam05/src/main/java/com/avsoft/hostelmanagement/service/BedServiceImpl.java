package com.avsoft.hostelmanagement.service;

import com.avsoft.hostelmanagement.dto.BedDto;
import com.avsoft.hostelmanagement.entity.Bed;
import com.avsoft.hostelmanagement.entity.Room;
import com.avsoft.hostelmanagement.exceptionHandler.HostelServiceExceptionHandler;
import com.avsoft.hostelmanagement.repostiory.BedRepository;
import com.avsoft.hostelmanagement.repostiory.RoomRepository;
import com.avsoft.hostelmanagement.service.BedService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BedServiceImpl implements BedService {

    @Autowired
    private BedRepository bedRepository;

    @Autowired
    private RoomRepository roomRepository;

    @Override
    public BedDto createBed(BedDto dto) {
        // 1. Validate Parent (Room)
        Room room = roomRepository.findById(dto.getRoomId())
                .orElseThrow(() -> new HostelServiceExceptionHandler("Room not found with id: " + dto.getRoomId(),HttpStatus.NOT_FOUND));

        // 2. Map DTO -> Entity
        Bed bed = new Bed();
        BeanUtils.copyProperties(dto, bed);

        // 3. Set Relations and Defaults
        bed.setRoom(room);
        if (bed.getStatus() == null) bed.setStatus("AVAILABLE");
        // If booked is null (from the copy), default it to FALSE
        if (bed.getBooked() == null) {
            bed.setBooked(false);
        }

        Bed savedBed = bedRepository.save(bed);

        // 4. Map Entity -> DTO
        return mapToDto(savedBed);
    }

    @Override
    public BedDto getBedById(Long id) {
        Bed bed = bedRepository.findById(id)
                .orElseThrow(() -> new HostelServiceExceptionHandler("Bed not found with id: " + id,HttpStatus.NOT_FOUND));
        return mapToDto(bed);
    }

    @Override
    public List<BedDto> getAllBeds() {
        return bedRepository.findAll().stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<BedDto> getBedsByRoom(Long roomId) {
        return bedRepository.findByRoomId(roomId).stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public BedDto updateBed(Long id, BedDto dto) {
        Bed existing = bedRepository.findById(id)
                .orElseThrow(() -> new HostelServiceExceptionHandler("Bed not found with id: " + id,HttpStatus.NOT_FOUND));

        // Update fields (only Admin fields, Booking fields are usually handled by BookingService)
        existing.setBedNo(dto.getBedNo());
        existing.setPrice(dto.getPrice());
        existing.setSharing(dto.getSharing());
        existing.setStatus(dto.getStatus());
        
        // If you want to allow manual booking updates via this API:
        existing.setBooked(dto.getBooked());
        existing.setBookedFrom(dto.getBookedFrom());
        existing.setBookedTo(dto.getBookedTo());

        Bed updated = bedRepository.save(existing);
        return mapToDto(updated);
    }

    @Override
    public void deleteBed(Long id) {
        if (!bedRepository.existsById(id)) {
            throw new HostelServiceExceptionHandler("Bed not found with id: " + id,HttpStatus.NOT_FOUND);
        }
        bedRepository.deleteById(id);
    }

    // Helper: Map Entity to DTO
    private BedDto mapToDto(Bed bed) {
        BedDto dto = new BedDto();
        BeanUtils.copyProperties(bed, dto);

        // Manual mapping for Parent ID
        if (bed.getRoom() != null) {
            dto.setRoomId(bed.getRoom().getId());
        }
        return dto;
    }
}