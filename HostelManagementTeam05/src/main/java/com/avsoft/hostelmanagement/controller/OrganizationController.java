package com.avsoft.hostelmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.avsoft.hostelmanagement.dto.OrganizationDto;
import com.avsoft.hostelmanagement.entity.Organization;
import com.avsoft.hostelmanagement.service.OrganizationService;

@RestController
@RequestMapping("/organization")
public class OrganizationController {

   
	@Autowired
	OrganizationService organizationService;
	
	@PostMapping("/org")
	public ResponseEntity<Organization> saveOrganization(@RequestBody OrganizationDto dto){
		Organization saveOrganization = organizationService.saveOrganization(dto);
		return new ResponseEntity<Organization>(saveOrganization,HttpStatus.CREATED);	
	}
	
	@GetMapping("/org/{id}")
	public ResponseEntity<Organization> getOrganizationById(@PathVariable Long id){
		Organization getById = organizationService.getOrganizationById(id);
		return new ResponseEntity<Organization>(getById,HttpStatus.OK);	
	}
	
	@GetMapping("/org")
	public ResponseEntity<List<Organization>> getAllOrganization(){
		List<Organization> allOrganizations = organizationService.getAllOrganizations();
		return new ResponseEntity<List<Organization>>(allOrganizations,HttpStatus.OK);
		
	}
	
	@DeleteMapping("/org/{id}")
	public ResponseEntity<String> deleteOrganization(@PathVariable Long id){
		organizationService.deleteOrganization(id);
		return new ResponseEntity<>("Organization deleted sucessfully",HttpStatus.NO_CONTENT);
		
	}

}
