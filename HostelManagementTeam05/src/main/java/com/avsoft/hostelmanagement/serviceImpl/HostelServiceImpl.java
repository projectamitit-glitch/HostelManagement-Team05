package com.avsoft.hostelmanagement.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.avsoft.hostelmanagement.dto.AddressDto;
import com.avsoft.hostelmanagement.dto.HostelDto;
import com.avsoft.hostelmanagement.entity.Address;
import com.avsoft.hostelmanagement.entity.Hostel;
import com.avsoft.hostelmanagement.entity.Organization;
import com.avsoft.hostelmanagement.exceptionHandler.HostelServiceExceptionHandler;
import com.avsoft.hostelmanagement.repostiory.AddressRepository;
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
	
	@Autowired
	AddressRepository addressRepository;

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
//		hostel.setAddress(hostelDto.getAddress());
		hostel.setCapacity(hostelDto.getCapacity());
		hostel.setContactNo(hostelDto.getContactNo());
		hostel.setGenderType(hostelDto.getGenderType());

		hostel.setOrganization(organization);
		
		if(hostelDto.getAddressDetails() != null) {
            Address addressEntity = new Address();
            
            addressEntity.setArea(hostelDto.getAddressDetails().getArea());
            addressEntity.setCity(hostelDto.getAddressDetails().getCity());
            addressEntity.setZipCode(hostelDto.getAddressDetails().getZipCode());
            addressEntity.setState(hostelDto.getAddressDetails().getState());
            addressEntity.setCountry(hostelDto.getAddressDetails().getCountry());

            // Link Address to Hostel
            hostel.setAddresss(addressEntity); 
            
            
            Address savedAddress = addressRepository.save(addressEntity);


            hostel.setAddresss(savedAddress);
        }

		return hostelRepository.save(hostel);

	}

	@Override
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
	
	@Override
    public List<HostelDto> searchHostels(String city, String area) {
        log.info("Searching hostels with City: {} and Area: {}", city, area);

        // 1. Fetch data using the optimized Repository query
        List<Hostel> hostels = hostelRepository.searchHostels(city, area);
        
        // 2. Create a list to hold the DTOs
        java.util.ArrayList<HostelDto> hostelDtos = new java.util.ArrayList<>();

        // 3. Simple for-each loop to convert Entity -> DTO (No Streams)
        for (Hostel hostel : hostels) {
            HostelDto dto = new HostelDto();
            
            // Map Basic Fields
            dto.setName(hostel.getName());
//            dto.setAddress(hostel.getAddress()); // This is the string address
            dto.setCapacity(hostel.getCapacity());
            dto.setContactNo(hostel.getContactNo());
            dto.setGenderType(hostel.getGenderType());
            
            if(hostel.getOrganization() != null) {
                dto.setOrganizationId(hostel.getOrganization().getId());
            }

            // Map Address Entity to AddressDto
            if (hostel.getAddresss() != null) {
                AddressDto addrDto = new AddressDto();
                addrDto.setId(hostel.getAddresss().getId());
                addrDto.setArea(hostel.getAddresss().getArea());
                addrDto.setCity(hostel.getAddresss().getCity());
                addrDto.setState(hostel.getAddresss().getState());
                addrDto.setCountry(hostel.getAddresss().getCountry());
                addrDto.setZipCode(hostel.getAddresss().getZipCode());
                
                dto.setAddressDetails(addrDto);
            }

            // Add to list
            hostelDtos.add(dto);
        }

        return hostelDtos;
    }
}
