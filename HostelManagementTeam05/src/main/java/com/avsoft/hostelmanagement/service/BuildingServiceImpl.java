package com.avsoft.hostelmanagement.service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.avsoft.hostelmanagement.dto.BuildingDto;
import com.avsoft.hostelmanagement.entity.Building;
import com.avsoft.hostelmanagement.entity.Hostel;
import com.avsoft.hostelmanagement.exceptionHandler.HostelServiceExceptionHandler;
import com.avsoft.hostelmanagement.repostiory.BuildingRepository;
import com.avsoft.hostelmanagement.repostiory.HostelRepository;

@Service
public class BuildingServiceImpl implements BuildingService {

    @Autowired
    private BuildingRepository buildingRepository;

    @Autowired
    private HostelRepository hostelRepository;

    @Override
    public BuildingDto createBuilding(BuildingDto dto) {
        // 1. Validate Parent (Hostel)
        Hostel hostel = hostelRepository.findById(dto.getHostelId())
                .orElseThrow(() -> new HostelServiceExceptionHandler("Hostel not found with id: " + dto.getHostelId(),HttpStatus.NOT_FOUND));

        // 2. Map DTO -> Entity
        Building building = new Building();
        BeanUtils.copyProperties(dto, building);

        // 3. Set Relations and Defaults
        building.setHostel(hostel);
        building.setCreatedAt(LocalDate.now());
        building.setUpdatedAt(LocalDate.now());
        if (building.getStatus() == null) building.setStatus("ACTIVE");

        Building savedBuilding = buildingRepository.save(building);

        // 4. Map Entity -> DTO
        return mapToDto(savedBuilding);
    }

    @Override
    public BuildingDto getBuildingById(Long id) {
        Building building = buildingRepository.findById(id)
                .orElseThrow(() -> new HostelServiceExceptionHandler("Building not found with id: " + id,HttpStatus.NOT_FOUND));
        return mapToDto(building);
    }

    @Override
    public List<BuildingDto> getAllBuildings() {
        return buildingRepository.findAll().stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<BuildingDto> getBuildingsByHostel(Long hostelId) {
        return buildingRepository.findByHostelId(hostelId).stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public BuildingDto updateBuilding(Long id, BuildingDto dto) {
        Building existing = buildingRepository.findById(id)
                .orElseThrow(() -> new HostelServiceExceptionHandler("Building not found with id: " + id,HttpStatus.NOT_FOUND));

        // Update fields
        existing.setName(dto.getName());
        existing.setFloors(dto.getFloors());
        existing.setWarden(dto.getWarden());
        existing.setContactNo(dto.getContactNo());
        existing.setMaintenanceRequired(dto.getMaintenanceRequired());
        existing.setUpdatedAt(LocalDate.now());

        Building updated = buildingRepository.save(existing);
        return mapToDto(updated);
    }

    @Override
    public void deleteBuilding(Long id) {
        if (!buildingRepository.existsById(id)) {
            throw new HostelServiceExceptionHandler("Building not found with id: " + id,HttpStatus.NOT_FOUND);
        }
        buildingRepository.deleteById(id);
    }

    // Helper: Map Entity to DTO
    private BuildingDto mapToDto(Building building) {
        BuildingDto dto = new BuildingDto();
        BeanUtils.copyProperties(building, dto);
        
        // Manual mapping for Parent ID
        if (building.getHostel() != null) {
            dto.setHostelId(building.getHostel().getId());
        }
        return dto;
    }
}