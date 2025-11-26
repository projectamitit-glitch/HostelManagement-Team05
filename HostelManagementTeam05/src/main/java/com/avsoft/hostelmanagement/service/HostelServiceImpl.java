package com.avsoft.hostelmanagement.service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.avsoft.hostelmanagement.dto.HostelDto;
import com.avsoft.hostelmanagement.entity.Hostel;
import com.avsoft.hostelmanagement.entity.Organization;
import com.avsoft.hostelmanagement.exceptionHandler.HostelServiceExceptionHandler;
import com.avsoft.hostelmanagement.repostiory.HostelRepository;
import com.avsoft.hostelmanagement.repostiory.OrganizationRepository;

@Service
public class HostelServiceImpl implements HostelService{
	
	@Autowired
    private HostelRepository hostelRepository;

    @Autowired
    private OrganizationRepository organizationRepository;

    @Override
    public HostelDto createHostel(HostelDto dto) {
        // 1. Validate Parent Organization exists
        Organization organization = organizationRepository.findById(dto.getOrganizationId())
                .orElseThrow(() -> new HostelServiceExceptionHandler("Organization not found with id: " + dto.getOrganizationId(),HttpStatus.NOT_FOUND));

        // 2. Map DTO to Entity
        Hostel hostel = new Hostel();
        BeanUtils.copyProperties(dto, hostel);
        
        // 3. Set Relationship and Metadata
        hostel.setOrganization(organization);
        hostel.setCreatedAt(LocalDate.now());
        hostel.setUpdatedAt(LocalDate.now());
        if (hostel.getStatus() == null) hostel.setStatus("ACTIVE");

        Hostel savedHostel = hostelRepository.save(hostel);

        // 4. Map back to DTO
        HostelDto responseDto = new HostelDto();
        BeanUtils.copyProperties(savedHostel, responseDto);
        responseDto.setOrganizationId(organization.getId());
        
        return responseDto;
    }

    @Override
    public HostelDto getHostelById(Long id) {
        Hostel hostel = hostelRepository.findById(id)
                .orElseThrow(() -> new HostelServiceExceptionHandler("Hostel not found with id: " + id,HttpStatus.NOT_FOUND));
        return mapToDto(hostel);
    }

    @Override
    public List<HostelDto> getAllHostels() {
        return hostelRepository.findAll().stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<HostelDto> getHostelsByOrganization(Long orgId) {
        return hostelRepository.findByOrganizationId(orgId).stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public HostelDto updateHostel(Long id, HostelDto dto) {
        Hostel existingHostel = hostelRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Hostel not found with id: " + id));

        // Update basic fields
        if (dto.getName() != null) existingHostel.setName(dto.getName());
        if (dto.getAddress() != null) existingHostel.setAddress(dto.getAddress());
        if (dto.getCapacity() != 0) existingHostel.setCapacity(dto.getCapacity()); // assuming capacity 0 means not sent
        if (dto.getContactNo() != null) existingHostel.setContactNo(dto.getContactNo());
        if (dto.getGenderType() != null) existingHostel.setGenderType(dto.getGenderType());

        // --- FIX FOR COORDINATES ---
        // Only update if the user actually sent new values
        if (dto.getLatitude() != null) {
            existingHostel.setLatitude(dto.getLatitude());
        }
        if (dto.getLongitude() != null) {
            existingHostel.setLongitude(dto.getLongitude());
        }

        existingHostel.setUpdatedAt(LocalDate.now());

        Hostel updatedHostel = hostelRepository.save(existingHostel);
        return mapToDto(updatedHostel);
    }

    @Override
    public void deleteHostel(Long id) {
        if (!hostelRepository.existsById(id)) {
            throw new HostelServiceExceptionHandler("Hostel not found with id: " + id,HttpStatus.NOT_FOUND);
        }
        hostelRepository.deleteById(id);
    }

    // Helper method to avoid code repetition
    private HostelDto mapToDto(Hostel hostel) {
        HostelDto dto = new HostelDto();
        BeanUtils.copyProperties(hostel, dto);
        // Manually set the Org ID because BeanUtils won't map Object -> Long
        if (hostel.getOrganization() != null) {
            dto.setOrganizationId(hostel.getOrganization().getId());
        }
        return dto;
    }
    
}
