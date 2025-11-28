package com.avsoft.hostelmanagement.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.avsoft.hostelmanagement.dto.HostelDto;
import com.avsoft.hostelmanagement.entity.Hostel;
import com.avsoft.hostelmanagement.entity.Organization;
import com.avsoft.hostelmanagement.exceptionHandler.HostelServiceExceptionHandler;
import com.avsoft.hostelmanagement.repostiory.HostelRepository;
import com.avsoft.hostelmanagement.repostiory.OrganizationRepository;
import com.avsoft.hostelmanagement.service.HostelService;

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
