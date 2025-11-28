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
import org.springframework.web.bind.annotation.RestController;

import com.avsoft.hostelmanagement.dto.HostelDto;
import com.avsoft.hostelmanagement.entity.Hostel;
import com.avsoft.hostelmanagement.service.HostelService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class HostelController {
	@Autowired
	HostelService hostelService;

	@PostMapping("/hostel")
	public ResponseEntity<Hostel> postHostel(@RequestBody HostelDto hostelDto) {
	    log.info("Controller received DTO: {}", hostelDto);

		Hostel hos = hostelService.saveHostel(hostelDto);
		return new ResponseEntity<Hostel>(hos, HttpStatus.CREATED);
	}
	
	@GetMapping("/getHostel/{id}")
	public ResponseEntity<Hostel> getbyId(@PathVariable long id) {
		 return new ResponseEntity<Hostel>(hostelService.getHostelById(id),HttpStatus.OK);
	}
	
	@GetMapping("/getAllforHostel")
	public ResponseEntity<List<Hostel>> getAll() {
		return new ResponseEntity<List<Hostel>>(hostelService.getHostel(),HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteHostel/{id}")
	public ResponseEntity<String> deleteHostel(@PathVariable Long id){
		hostelService.deleteHostel(id);
		return new ResponseEntity<>("Organization deleted sucessfully",HttpStatus.NO_CONTENT);
		
	}
	
	@DeleteMapping("/deleteAllHostel")
	public ResponseEntity<String> deleteAll(){
		hostelService.deleteAllHostel();
		return new ResponseEntity<>("Organization deleted sucessfully",HttpStatus.NO_CONTENT);
		
	}

}
