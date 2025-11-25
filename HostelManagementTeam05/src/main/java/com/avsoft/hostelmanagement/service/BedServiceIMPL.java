package com.avsoft.hostelmanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avsoft.hostelmanagement.entity.Bed;
import com.avsoft.hostelmanagement.repostiory.BedRepository;

@Service
public class BedServiceIMPL implements BedService{
	
	
	@Autowired
	BedRepository bedRepository;

	@Override
	public String saveBed(Bed bed) {
		
		bedRepository.save(bed);
		return "bed added";
	}

}
