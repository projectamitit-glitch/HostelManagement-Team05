package com.avsoft.hostelmanagement.service;

import java.util.List;

import com.avsoft.hostelmanagement.dto.HostelDto;
import com.avsoft.hostelmanagement.entity.Hostel;

public interface HostelService {

    Hostel saveHostel(HostelDto hostelDto);

    List<Hostel> getHostel();

    Hostel getHostelById(Long id);

    void deleteHostel(Long id);

    void deleteAllHostel();

    List<HostelDto> searchHostels(String city, String area);

    Hostel addFloorCount(Long hostelId, int floorCount);

    int getFloorCount(Long hostelId);
}
