package com.avsoft.hostelmanagement.serviceImpl;

<<<<<<< HEAD
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.avsoft.hostelmanagement.dto.OrganizationDto;
import com.avsoft.hostelmanagement.entity.Organization;
import com.avsoft.hostelmanagement.exceptionHandler.OrganizationException;
=======
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avsoft.hostelmanagement.entity.Hostel;
import com.avsoft.hostelmanagement.entity.Organization;
import com.avsoft.hostelmanagement.repostiory.HostelRepository;
>>>>>>> remotes/origin/feature/samiksha/#11
import com.avsoft.hostelmanagement.repostiory.OrganizationRepository;
import com.avsoft.hostelmanagement.service.OrganizationService;

@Service
<<<<<<< HEAD
public class OrganizationServiceImpl implements OrganizationService{
	
	@Autowired
	OrganizationRepository organizationRepository;

	@Override
	public Organization saveOrganization(OrganizationDto dto) {
		
		Organization org = new Organization();
		org.setOrgName(dto.getOrgName());
		org.setAddress(dto.getAddress());
		org.setEmail(dto.getEmail());
		org.setContactNo(dto.getContactNo());
		org.setWebsite(dto.getWebsite());
		
		return organizationRepository.save(org);
	}

	@Override
	public Organization getOrganizationById(Long id) {
		if(id == null) {
			throw new OrganizationException("Id should not be null",HttpStatus.BAD_REQUEST);
		}
		Organization organization = organizationRepository.findById(id).get();
		if(organization == null) {
			throw new OrganizationException("Organization not found with id : "+id,HttpStatus.NOT_FOUND);
		}
		
		return organization;
	}

	@Override
	public List<Organization> getAllOrganizations() {
		List<Organization> AllOrganization = organizationRepository.findAll();
		return AllOrganization;
	}

	@Override
	public void deleteOrganization(Long id) {
		if(id == null) {
			throw new OrganizationException("ID should not be null",HttpStatus.BAD_REQUEST);
		}
		 Organization organization = organizationRepository.findById(id).get();
		 if (organization == null) {
			 throw new OrganizationException("organization not found with id : "+id,HttpStatus.BAD_REQUEST);
		 }
		organizationRepository.delete(organization);
	}

}
=======
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

>>>>>>> remotes/origin/feature/samiksha/#11
