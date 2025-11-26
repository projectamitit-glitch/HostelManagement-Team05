package com.avsoft.hostelmanagement.service;

import com.avsoft.hostelmanagement.dto.BedDto;
import java.util.List;

public interface BedService {

    BedDto createBed(BedDto dto);

    BedDto getBedById(Long id);

    List<BedDto> getAllBeds();

    List<BedDto> getBedsByRoom(Long roomId);

    BedDto updateBed(Long id, BedDto dto);

    void deleteBed(Long id);
}