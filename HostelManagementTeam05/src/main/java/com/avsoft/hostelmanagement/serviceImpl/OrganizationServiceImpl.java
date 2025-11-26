package com.avsoft.hostelmanagement.serviceImpl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avsoft.hostelmanagement.entity.Hostel;
import com.avsoft.hostelmanagement.entity.Organization;
import com.avsoft.hostelmanagement.repostiory.HostelRepository;
import com.avsoft.hostelmanagement.repostiory.OrganizationRepository;
import com.avsoft.hostelmanagement.service.OrganizationService;

@Service
public class OrganizationServiceImpl implements OrganizationService {

    @Autowired
    private OrganizationRepository organizationRepository;

    @Override
    public Organization addOrganization(Organization organization) {

        organization.setCreatedAt(LocalDate.now()); 
        organization.setUpdatedAt(LocalDate.now());
        organization.setStatus("ACTIVE");

        if (organization.getHostels() != null) {

            for (Hostel hostel : organization.getHostels()) {
            	
                hostel.setOrganization(organization); 
   
            }
        }

        return organizationRepository.save(organization);
    }
    
    @Override
    public List<Organization> addOrganizations(List<Organization> organizations) {

        for (Organization org : organizations) {

            org.setCreatedAt(LocalDate.now());
            org.setUpdatedAt(LocalDate.now());
            org.setStatus("ACTIVE");

            if (org.getHostels() != null) {

                for (Hostel hostel : org.getHostels()) {
                    hostel.setOrganization(org);
                }
            }
        }

        return organizationRepository.saveAll(organizations);
        
    }

    @Override
    public Organization getOrganizationById(Long id) {

        return organizationRepository.findById(id).orElseThrow(() -> new RuntimeException("Organization not found with ID: " + id));
        
    }

    @Override
    public List<Organization> getAllOrganizations() {

        return organizationRepository.findAll();
        
    }

}

