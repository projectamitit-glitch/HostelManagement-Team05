package com.avsoft.hostelmanagement.serviceImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.avsoft.hostelmanagement.dto.OrganizationDto;
import com.avsoft.hostelmanagement.entity.Floor;
import com.avsoft.hostelmanagement.entity.Organization;
import com.avsoft.hostelmanagement.exceptionHandler.OrganizationException;
import com.avsoft.hostelmanagement.repostiory.OrganizationRepository;
import com.avsoft.hostelmanagement.response.PaginationResponse;
import com.avsoft.hostelmanagement.service.OrganizationService;

@Service
public class OrganizationServiceImpl implements OrganizationService {

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
		if (id == null) {
			throw new OrganizationException("Id should not be null", HttpStatus.BAD_REQUEST);
		}
		Organization organization = organizationRepository.findById(id).get();
		if (organization == null) {
			throw new OrganizationException("Organization not found with id : " + id, HttpStatus.NOT_FOUND);
		}

		return organization;
	}

	@Override
	public PaginationResponse<Organization> getAllOrganizations(Integer pageNumber, Integer pageSize) {

		Pageable pageable = PageRequest.of(pageNumber, pageSize);
		Page<Organization> pageOrganization = organizationRepository.findAll(pageable);

		PaginationResponse<Organization> postResponse = new PaginationResponse<>();
		postResponse.setContent(pageOrganization.getContent());
		postResponse.setPageNumber(pageOrganization.getNumber());
		postResponse.setPageSize(pageOrganization.getSize());
		postResponse.setTotalElements(pageOrganization.getTotalElements());
		postResponse.setTotalPages(pageOrganization.getTotalPages());
		postResponse.setLastPage(pageOrganization.isLast());

		return postResponse;
	}

	@Override
	public void deleteOrganization(Long id) {
		if (id == null) {
			throw new OrganizationException("ID should not be null", HttpStatus.BAD_REQUEST);
		}
		Organization organization = organizationRepository.findById(id).get();
		if (organization == null) {
			throw new OrganizationException("organization not found with id : " + id, HttpStatus.BAD_REQUEST);
		}
		organizationRepository.delete(organization);
	}

}
