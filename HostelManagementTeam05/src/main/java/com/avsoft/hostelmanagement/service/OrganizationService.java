package com.avsoft.hostelmanagement.service;

import java.util.List;

import com.avsoft.hostelmanagement.entity.Organization;

public interface OrganizationService {

    Organization addOrganization(Organization organization);
    
    List<Organization> addOrganizations(List<Organization> organizations);

    Organization getOrganizationById(Long id);

    List<Organization> getAllOrganizations();

}

