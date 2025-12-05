package com.avsoft.hostelmanagement.service;

import java.util.List;

<<<<<<< HEAD
import com.avsoft.hostelmanagement.dto.OrganizationDto;
=======
>>>>>>> remotes/origin/feature/samiksha/#11
import com.avsoft.hostelmanagement.entity.Organization;

public interface OrganizationService {
	
	Organization saveOrganization(OrganizationDto dto);  
    Organization getOrganizationById(Long id);
    List<Organization> getAllOrganizations();
    void deleteOrganization(Long id);
	

    Organization addOrganization(Organization organization);
    
    List<Organization> addOrganizations(List<Organization> organizations);

    Organization getOrganizationById(Long id);

    List<Organization> getAllOrganizations();

}

