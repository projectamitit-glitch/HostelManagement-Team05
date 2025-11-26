package com.avsoft.hostelmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.avsoft.hostelmanagement.dto.ApiResponse;
import com.avsoft.hostelmanagement.dto.OrganizationDto;
import com.avsoft.hostelmanagement.service.OrganizationService;

@RestController
@RequestMapping("/api/organizations")
public class OrganizationController {
	
	@Autowired
	OrganizationService organizationService;
	
	@PostMapping
	public ResponseEntity<ApiResponse<OrganizationDto>> createOrganization(@RequestBody OrganizationDto dto){
		OrganizationDto createdOrgDto = organizationService.createOrganization(dto);
		return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse<>("SUCCESS","Organization created successfully",createdOrgDto));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ApiResponse<OrganizationDto>> getOrganization(@PathVariable Long id){
		OrganizationDto org = organizationService.getOrganizationById(id);
		return ResponseEntity.ok(new ApiResponse<>("SUCCESS","Organization fetched successfully",org));
	}
	
	@GetMapping
	public ResponseEntity<ApiResponse<List<OrganizationDto>>> getAllOrganization(){
		List<OrganizationDto> orgs = organizationService.getAllOrganizations();
		return ResponseEntity.ok(new ApiResponse<>("SUCCESS","All Organizations fetched Successfully",orgs));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ApiResponse<OrganizationDto>> updateOrganization(@PathVariable long id, @RequestBody OrganizationDto dto){
		OrganizationDto updatedOrgDto = organizationService.updateOrganization(id, dto);
		return ResponseEntity.ok(new ApiResponse<>("SUCCESS","Organization updated successfully",updatedOrgDto));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ApiResponse<String>> deleteOrganization(@PathVariable long id){
		organizationService.deleteOrganization(id);
		return ResponseEntity.ok(new ApiResponse<>("SUCCESS","Organization Deletyed Successfully",null));
	}
}
