package com.avsoft.hostelmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.avsoft.hostelmanagement.entity.Organization;
import com.avsoft.hostelmanagement.service.OrganizationService;

@RestController
@RequestMapping("/organization")
public class OrganizationController {

    @Autowired
    private OrganizationService organizationService;

    @PostMapping("/add")
    public ResponseEntity<Organization> add(@RequestBody Organization organization) {
    	
        return ResponseEntity.ok(organizationService.addOrganization(organization));
        
    }

    @PostMapping("/add-multiple")
    public ResponseEntity<List<Organization>> addMultiple(@RequestBody List<Organization> organizations) {
    	
        return ResponseEntity.ok(organizationService.addOrganizations(organizations));
        
    }

    @GetMapping("/all")
    public ResponseEntity<List<Organization>> getAll() {
    	
        return ResponseEntity.ok(organizationService.getAllOrganizations());
        
    }

    @GetMapping("/{id}")
    public ResponseEntity<Organization> getById(@PathVariable Long id) {
    	
        return ResponseEntity.ok(organizationService.getOrganizationById(id));
        
    }
}
