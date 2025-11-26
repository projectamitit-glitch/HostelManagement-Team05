package com.avsoft.hostelmanagement.service;

import java.util.List;

import com.avsoft.hostelmanagement.dto.HostelDto;

public interface HostelService {
    
    HostelDto createHostel(HostelDto dto);
    
    HostelDto getHostelById(Long id);
    
    List<HostelDto> getAllHostels();
    
    List<HostelDto> getHostelsByOrganization(Long orgId);
    
    HostelDto updateHostel(Long id, HostelDto dto);
    
    void deleteHostel(Long id);
}
