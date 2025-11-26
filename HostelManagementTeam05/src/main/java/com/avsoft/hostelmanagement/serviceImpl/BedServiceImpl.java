package com.avsoft.hostelmanagement.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avsoft.hostelmanagement.entity.Bed;
import com.avsoft.hostelmanagement.entity.Room;
import com.avsoft.hostelmanagement.repostiory.BedRepository;
import com.avsoft.hostelmanagement.repostiory.RoomRepository;
import com.avsoft.hostelmanagement.service.BedService;

@Service
public class BedServiceImpl implements BedService {

    @Autowired
    private BedRepository bedRepository;

    @Autowired
    private RoomRepository roomRepository;

    @Override
    public Bed saveBed(Bed bed, Long roomId) {

        Room room = roomRepository.findById(roomId).orElseThrow(() -> new RuntimeException("Room not found with id: " + roomId));

        bed.setRoom(room);

        return bedRepository.save(bed);
        
    }

    @Override
    public List<Bed> saveAllBeds(List<Bed> beds, Long roomId) {

        Room room = roomRepository.findById(roomId).orElseThrow(() -> new RuntimeException("Room not found with id: " + roomId));

        for (Bed bed : beds) {
            bed.setRoom(room);
        }

        return bedRepository.saveAll(beds);
    }

    @Override
    public Bed getBedById(Long id) {
    	
        return bedRepository.findById(id).orElseThrow(() -> new RuntimeException("Bed not found with id: " + id));
        
    }

    @Override
    public List<Bed> getAvailableBedsBySharing(int sharing, String status) {
    	
        return bedRepository.findByStatusAndSharing(status, sharing);
        
    }

    @Override
    public List<Bed> getVacantBedBySharingAndHostel(int sharing, Long hostelId) {
    	
        return bedRepository.findBySharingAndRoom_Hostel_Id(sharing, hostelId);
        
    }

}

