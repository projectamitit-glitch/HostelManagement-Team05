package com.avsoft.hostelmanagement.serviceImpl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avsoft.hostelmanagement.entity.Building;
import com.avsoft.hostelmanagement.entity.Hostel;
import com.avsoft.hostelmanagement.entity.Organization;
import com.avsoft.hostelmanagement.repostiory.HostelRepository;
import com.avsoft.hostelmanagement.repostiory.OrganizationRepository;
import com.avsoft.hostelmanagement.service.HostelService;

@Service
public class HostelServiceImpl implements HostelService {

    @Autowired
    private HostelRepository hostelRepository;
    
    @Autowired
    private OrganizationRepository organizationRepo;

    @Override
    public Hostel saveHostel(Hostel hostel, Long organizationId) {

        Organization org = organizationRepo.findById(organizationId).orElseThrow(() -> 
        new RuntimeException("Organization not found with id: " + organizationId));
        
        hostel.setOrganization(org);

        hostel.setStatus("ACTIVE");
        hostel.setCreatedAt(LocalDate.now());
        hostel.setUpdatedAt(LocalDate.now());

        if (hostel.getBuildings() != null) {
            for (Building building : hostel.getBuildings()) {
                building.setHostel(hostel);
            }
        }

        return hostelRepository.save(hostel);
    }
    
    @Override
    public List<Hostel> saveAllHostels(List<Hostel> hostels, Long organizationId) {

        Organization org = organizationRepo.findById(organizationId).orElseThrow(() -> new RuntimeException("Organization not found with id: " + organizationId));

        for (Hostel hostel : hostels) {

            hostel.setOrganization(org);

            hostel.setStatus("ACTIVE");
            hostel.setCreatedAt(LocalDate.now());
            hostel.setUpdatedAt(LocalDate.now());

            if (hostel.getBuildings() != null) {
                for (Building b : hostel.getBuildings()) {
                    b.setHostel(hostel);
                }
            }
        }

        return hostelRepository.saveAll(hostels);
        
    }

    @Override
    public Hostel getHostelById(Long id) {
    	
        return hostelRepository.findById(id).orElseThrow(() -> new RuntimeException("Hostel not found with id: " + id));
        
    }

    @Override
    public List<Hostel> getAllHostels() {
    	
        return hostelRepository.findAll();
        
    }

}

