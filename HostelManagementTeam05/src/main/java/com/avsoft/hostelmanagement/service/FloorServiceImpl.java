package com.avsoft.hostelmanagement.service;

import com.avsoft.hostelmanagement.dto.FloorDto;
import com.avsoft.hostelmanagement.entity.Building;
import com.avsoft.hostelmanagement.entity.Floor;
import com.avsoft.hostelmanagement.exceptionHandler.HostelServiceExceptionHandler;
import com.avsoft.hostelmanagement.repostiory.BuildingRepository;
import com.avsoft.hostelmanagement.repostiory.FloorRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FloorServiceImpl implements FloorService {

    @Autowired
    private FloorRepository floorRepository;

    @Autowired
    private BuildingRepository buildingRepository;

    @Override
    public FloorDto createFloor(FloorDto dto) {
        // 1. Validate Parent (Building)
        Building building = buildingRepository.findById(dto.getBuildingId())
                .orElseThrow(() -> new HostelServiceExceptionHandler("Building not found with id: " + dto.getBuildingId(),HttpStatus.NOT_FOUND));

        // 2. Map DTO -> Entity
        Floor floor = new Floor();
        BeanUtils.copyProperties(dto, floor);

        // 3. Set Relations
        floor.setBuilding(building);
        if (floor.getStatus() == null) floor.setStatus("ACTIVE");

        Floor savedFloor = floorRepository.save(floor);

        // 4. Map Entity -> DTO
        return mapToDto(savedFloor);
    }

    @Override
    public FloorDto getFloorById(Long id) {
        Floor floor = floorRepository.findById(id)
                .orElseThrow(() -> new HostelServiceExceptionHandler("Floor not found with id: " + id,HttpStatus.NOT_FOUND));
        return mapToDto(floor);
    }

    @Override
    public List<FloorDto> getAllFloors() {
        return floorRepository.findAll().stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<FloorDto> getFloorsByBuilding(Long buildingId) {
        return floorRepository.findByBuildingId(buildingId).stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public FloorDto updateFloor(Long id, FloorDto dto) {
        Floor existing = floorRepository.findById(id)
                .orElseThrow(() -> new HostelServiceExceptionHandler("Floor not found with id: " + id,HttpStatus.NOT_FOUND));

        // Update fields
        existing.setFloorNo(dto.getFloorNo());
        existing.setNoOfRooms(dto.getNoOfRooms());
        existing.setFloorType(dto.getFloorType());
        existing.setStatus(dto.getStatus());
        
        Floor updated = floorRepository.save(existing);
        return mapToDto(updated);
    }

    @Override
    public void deleteFloor(Long id) {
        if (!floorRepository.existsById(id)) {
            throw new HostelServiceExceptionHandler("Floor not found with id: " + id,HttpStatus.NOT_FOUND);
        }
        floorRepository.deleteById(id);
    }

    // Helper: Map Entity to DTO
    private FloorDto mapToDto(Floor floor) {
        FloorDto dto = new FloorDto();
        BeanUtils.copyProperties(floor, dto);

        // Manual mapping for Parent ID
        if (floor.getBuilding() != null) {
            dto.setBuildingId(floor.getBuilding().getId());
        }
        return dto;
    }
}