package com.avsoft.hostelmanagement.service;

import java.util.List;

import com.avsoft.hostelmanagement.entity.Hostel;

public interface HostelService {

    Hostel saveHostel(Hostel hostel, Long organizationId);
    
    List<Hostel> saveAllHostels(List<Hostel> hostels, Long organizationId);

    Hostel getHostelById(Long id);

    List<Hostel> getAllHostels();

}

