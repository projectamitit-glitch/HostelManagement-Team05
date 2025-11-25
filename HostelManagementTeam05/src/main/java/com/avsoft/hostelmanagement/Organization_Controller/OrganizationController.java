package com.avsoft.hostelmanagement.Organization_Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.avsoft.hostelmanagement.entity.Bed;
import com.avsoft.hostelmanagement.service.BedService;

@RestController
@RequestMapping("/bed")
public class OrganizationController { 
	
	@Autowired
	BedService bedService;
	
	
	@PostMapping("/add")
	String addBed(@RequestBody Bed bed){
		bedService.saveBed(bed);
		return "bed added";
	}

}
