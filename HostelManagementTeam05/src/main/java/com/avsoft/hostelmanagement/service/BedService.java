package com.avsoft.hostelmanagement.service;

import java.util.List;

import com.avsoft.hostelmanagement.entity.Bed;

public interface BedService {

    Bed saveBed(Bed bed, Long roomId);

    List<Bed> saveAllBeds(List<Bed> beds, Long roomId);

    Bed getBedById(Long id);

    List<Bed> getAvailableBedsBySharing(int sharing, String status);

    List<Bed> getVacantBedBySharingAndHostel(int sharing, Long hostelId);
}

