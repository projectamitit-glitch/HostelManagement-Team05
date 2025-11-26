package com.avsoft.hostelmanagement.service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.avsoft.hostelmanagement.dto.OrganizationDto;
import com.avsoft.hostelmanagement.entity.Organization;
import com.avsoft.hostelmanagement.exceptionHandler.HostelServiceExceptionHandler;
import com.avsoft.hostelmanagement.repostiory.OrganizationRepository;

@Service
public class OrganizationServiceImpl implements OrganizationService {
	
	@Autowired
	private OrganizationRepository organizationRepository;
	
	@Override
	public OrganizationDto createOrganization(OrganizationDto dto) {
		Organization org = new Organization();
		org.setOrgName(dto.getOrgName());
		org.setAddress(dto.getAddress());
		org.setEmail(dto.getEmail());
		org.setContactNo(dto.getContactNo());
		org.setWebsite(dto.getWebsite());
		org.setGstNo(dto.getGstNo());
		org.setLogoUrl(dto.getLogoUrl());
		
		// Set Default Values
        org.setCreatedAt(LocalDate.now());
        org.setUpdatedAt(LocalDate.now());
        if (org.getStatus() == null || org.getStatus().isEmpty()) {
            org.setStatus("ACTIVE");
        }
        
        Organization savedOrg = organizationRepository.save(org);
        dto.setId(savedOrg.getId());
        dto.setCreatedAt(savedOrg.getCreatedAt());
        dto.setUpdatedAt(savedOrg.getUpdatedAt());
        dto.setStatus(savedOrg.getStatus());
        
		return dto;
	}

	@Override
	public OrganizationDto getOrganizationById(Long id) {
		Organization org = organizationRepository.findById(id)
                .orElseThrow(() -> new HostelServiceExceptionHandler("Organization not found with id: " + id,HttpStatus.NOT_FOUND));
        
        OrganizationDto dto = new OrganizationDto();
        BeanUtils.copyProperties(org, dto);
        return dto;
	}

	@Override
	public List<OrganizationDto> getAllOrganizations() {
		
        List<Organization> organizations = organizationRepository.findAll();
        
        return organizations.stream().map(org -> {
            OrganizationDto dto = new OrganizationDto();
            BeanUtils.copyProperties(org, dto);
            return dto;
        }).collect(Collectors.toList());
	}

	@Override
	public OrganizationDto updateOrganization(Long id, OrganizationDto dto) {
		Organization existingOrg = organizationRepository.findById(id)
                .orElseThrow(() -> new HostelServiceExceptionHandler("Organization not found with id: " + id,HttpStatus.NOT_FOUND));

        // Update fields
        existingOrg.setOrgName(dto.getOrgName());
        existingOrg.setAddress(dto.getAddress());
        existingOrg.setEmail(dto.getEmail());
        existingOrg.setContactNo(dto.getContactNo());
        existingOrg.setWebsite(dto.getWebsite());
        existingOrg.setGstNo(dto.getGstNo());
        existingOrg.setLogoUrl(dto.getLogoUrl());
        
        existingOrg.setUpdatedAt(LocalDate.now());
        
        Organization updatedOrg = organizationRepository.save(existingOrg);
        
        BeanUtils.copyProperties(updatedOrg, dto);
        return dto;
	}

	@Override
	public void deleteOrganization(Long id) {
		Organization org = organizationRepository.findById(id)
                .orElseThrow(() -> new HostelServiceExceptionHandler("Organization not found with id: " + id,HttpStatus.NOT_FOUND));
        
        organizationRepository.delete(org);
		
	}

}
