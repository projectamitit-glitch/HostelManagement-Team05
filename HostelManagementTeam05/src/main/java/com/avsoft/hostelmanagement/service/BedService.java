package com.avsoft.hostelmanagement.service;

import java.util.List;

import com.avsoft.hostelmanagement.dto.BedDto;
import com.avsoft.hostelmanagement.entity.Bed;

public interface BedService {
	
	
	Bed saveBed(Long roomId, BedDto dto);

	Bed getBedById(Long id);

    PaginationResponse getAllBeds(Integer pageNumber, Integer pageSize);

	void deleteBed(Long id);

	void deleteAllBeds();

}
