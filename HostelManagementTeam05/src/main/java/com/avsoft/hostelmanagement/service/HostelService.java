package com.avsoft.hostelmanagement.service;

import java.util.List;

<<<<<<< HEAD
import com.avsoft.hostelmanagement.dto.HostelDto;
=======
>>>>>>> remotes/origin/feature/samiksha/#11
import com.avsoft.hostelmanagement.entity.Hostel;

public interface HostelService {
	public Hostel saveHostel(HostelDto hoselDto);
	public List<Hostel> getHostel();
	public Hostel getHostelById(Long id);
	public void deleteHostel(Long id);
	public void deleteAllHostel();

    Hostel saveHostel(Hostel hostel, Long organizationId);
    
    List<Hostel> saveAllHostels(List<Hostel> hostels, Long organizationId);

    Hostel getHostelById(Long id);

    List<Hostel> getAllHostels();

}

