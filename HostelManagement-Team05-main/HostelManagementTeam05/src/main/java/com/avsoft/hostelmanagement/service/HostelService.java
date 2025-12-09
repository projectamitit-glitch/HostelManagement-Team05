package com.avsoft.hostelmanagement.service;

import java.util.List;

import com.avsoft.hostelmanagement.dto.HostelDto;
import com.avsoft.hostelmanagement.entity.Hostel;

public interface HostelService {
	public Hostel saveHostel(HostelDto hoselDto);
	public List<Hostel> getHostel();
	public Hostel getHostelById(Long id);
	public void deleteHostel(Long id);
	public void deleteAllHostel();
	public List<HostelDto> searchHostels(String city, String area);
}
