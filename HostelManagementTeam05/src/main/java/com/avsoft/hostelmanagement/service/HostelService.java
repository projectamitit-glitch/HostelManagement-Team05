package com.avsoft.hostelmanagement.service;

import java.util.List;

import com.avsoft.hostelmanagement.dto.HostelDto;
import com.avsoft.hostelmanagement.entity.Hostel;
import com.avsoft.hostelmanagement.response.PaginationResponse;

public interface HostelService {
	public Hostel saveHostel(HostelDto hoselDto);

	PaginationResponse getHostel(Integer pageNumber, Integer pageSize);

	public Hostel getHostelById(Long id);

	public void deleteHostel(Long id);

	public void deleteAllHostel();

}
