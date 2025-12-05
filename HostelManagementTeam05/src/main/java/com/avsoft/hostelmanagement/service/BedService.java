package com.avsoft.hostelmanagement.service;

import java.util.List;

<<<<<<< HEAD
import com.avsoft.hostelmanagement.dto.BedDto;
=======
>>>>>>> remotes/origin/feature/samiksha/#11
import com.avsoft.hostelmanagement.entity.Bed;

public interface BedService {
	
	
    Bed saveBed(Long roomId, BedDto dto);

    Bed getBedById(Long id);

    List<Bed> getAllBeds();

    void deleteBed(Long id);

    void deleteAllBeds();

    Bed saveBed(Bed bed, Long roomId);

    List<Bed> saveAllBeds(List<Bed> beds, Long roomId);

    Bed getBedById(Long id);

    List<Bed> getAvailableBedsBySharing(int sharing, String status);

    List<Bed> getVacantBedBySharingAndHostel(int sharing, Long hostelId);
}

