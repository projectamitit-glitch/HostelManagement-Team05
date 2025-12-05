package com.avsoft.hostelmanagement.serviceImpl;

<<<<<<< HEAD
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.avsoft.hostelmanagement.dto.HostelDto;
import com.avsoft.hostelmanagement.entity.Hostel;
import com.avsoft.hostelmanagement.entity.Organization;
import com.avsoft.hostelmanagement.exceptionHandler.HostelServiceExceptionHandler;
=======
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avsoft.hostelmanagement.entity.Building;
import com.avsoft.hostelmanagement.entity.Hostel;
import com.avsoft.hostelmanagement.entity.Organization;
>>>>>>> remotes/origin/feature/samiksha/#11
import com.avsoft.hostelmanagement.repostiory.HostelRepository;
import com.avsoft.hostelmanagement.repostiory.OrganizationRepository;
import com.avsoft.hostelmanagement.service.HostelService;

<<<<<<< HEAD
import lombok.extern.slf4j.Slf4j;
@Slf4j
@Service
public class HostelServiceImpl implements HostelService {

	@Autowired
	HostelRepository hostelRepository;

	@Autowired
	OrganizationRepository organizationRepository;

	public Hostel saveHostel(HostelDto hostelDto) {

		log.info("saving hostel method");
		log.info("Org ID = " + hostelDto.getOrganizationId());

		Organization organization = organizationRepository.findById
				(hostelDto.getOrganizationId()).orElse(null);
		
		if (organization == null) {
			throw new RuntimeException("Organization ID cannot be null");
		}

		Hostel hostel = new Hostel();
		hostel.setName(hostelDto.getName());
		hostel.setAddress(hostelDto.getAddress());
		hostel.setCapacity(hostelDto.getCapacity());
		hostel.setContactNo(hostelDto.getContactNo());
		hostel.setGenderType(hostelDto.getGenderType());

		hostel.setOrganization(organization);

		return hostelRepository.save(hostel);

	}

	@Override
	public List<Hostel> getHostel() {
		log.info("getting all haostel data!");
		
		
		return hostelRepository.findAll();
	}

	@Override
	public Hostel getHostelById(Long id) {
		
		log.info("getting data by id!");
		
		Hostel hostel= hostelRepository.findById(id).get();
		
		if (hostel == null) {
            throw new HostelServiceExceptionHandler("Hostel not found with id: " + id, HttpStatus.NOT_FOUND);
        }

		
		Hostel hostel2= hostelRepository.findById(id).get();
		return hostel2;
	}

	@Override
	public void deleteHostel(Long id) {
		
		log.info("delete data by id");
		
		
		
		Hostel hostel=hostelRepository.findById(id).get();
		
		 if (hostel == null) {
	            throw new HostelServiceExceptionHandler("Hostel not found with id: " + id, HttpStatus.NOT_FOUND);
	        }
		
		hostelRepository.delete(hostel);
		
	}

	@Override
	public void deleteAllHostel() {
		
		hostelRepository.deleteAll();
		
	}
}
=======
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

>>>>>>> remotes/origin/feature/samiksha/#11
