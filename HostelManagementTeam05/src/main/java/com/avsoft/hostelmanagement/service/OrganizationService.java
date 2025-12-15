package com.avsoft.hostelmanagement.service;

import java.util.List;

import com.avsoft.hostelmanagement.dto.OrganizationDto;
import com.avsoft.hostelmanagement.entity.Organization;
import com.avsoft.hostelmanagement.response.PaginationResponse;

public interface OrganizationService {

	Organization saveOrganization(OrganizationDto dto);

	Organization getOrganizationById(Long id);

	PaginationResponse getAllOrganizations(Integer pageNumber, Integer pageSize);

	void deleteOrganization(Long id);

}
