package com.avsoft.hostelmanagement.service;

import java.util.List;

import com.avsoft.hostelmanagement.dto.OrganizationDto;
import com.avsoft.hostelmanagement.entity.Organization;

public interface OrganizationService {
	
	Organization saveOrganization(OrganizationDto dto);  
    Organization getOrganizationById(Long id);
    List<Organization> getAllOrganizations();
    void deleteOrganization(Long id);
	

}
