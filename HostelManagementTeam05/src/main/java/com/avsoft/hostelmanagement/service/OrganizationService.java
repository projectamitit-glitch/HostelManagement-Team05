package com.avsoft.hostelmanagement.service;

import java.util.List;
import com.avsoft.hostelmanagement.dto.OrganizationDto;

public interface OrganizationService {
	
    OrganizationDto createOrganization(OrganizationDto dto);
    
    OrganizationDto getOrganizationById(Long id);
    
    List<OrganizationDto> getAllOrganizations();
    
    OrganizationDto updateOrganization(Long id, OrganizationDto dto);
    
    void deleteOrganization(Long id);
}
