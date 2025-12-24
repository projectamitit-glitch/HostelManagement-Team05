package com.avsoft.hostelmanagement.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.avsoft.hostelmanagement.dto.BedDto;
import com.avsoft.hostelmanagement.entity.Bed;
import com.avsoft.hostelmanagement.entity.Room;
import com.avsoft.hostelmanagement.exceptionHandler.BedException;
import com.avsoft.hostelmanagement.repostiory.BedRepository;
import com.avsoft.hostelmanagement.repostiory.RoomRepository;
import com.avsoft.hostelmanagement.service.BedService;





@Service
public class BedServiceImpl implements BedService{
	
	
	
    @Autowired
   BedRepository bedRepository;

    @Autowired
    RoomRepository roomRepository;

	@Override
	public Bed saveBed(Long roomId, BedDto dto) {
		
		
		Room room = roomRepository.findById(roomId).orElse(null);

        if (room == null) {
            throw new BedException("Room not found with id: " + roomId, HttpStatus.NOT_FOUND);
        }

        Bed bed = new Bed();
        bed.setBedNo(dto.getBedNo());
        bed.setStatus(dto.getStatus());
        bed.setPrice(dto.getPrice());
        bed.setSharing(dto.getSharing());

        bed.setRoom(room); 

        return bedRepository.save(bed);
	}

	
	
	
	@Override
	public Bed getBedById(Long id) {
		
		 Bed bed = bedRepository.findById(id).orElse(null);

	        if (bed == null) {
	            throw new BedException("Bed not found with id: " + id, HttpStatus.NOT_FOUND);
	        }

	        return bed;
		
	}

	@Override
	public List<Bed> getAllBeds() {
		 return bedRepository.findAll();
	}

	@Override
	public void deleteBed(Long id) {
		 Bed bed = bedRepository.findById(id).orElse(null);

	        if (bed == null) {
	            throw new BedException("Bed not found with id: " + id, HttpStatus.NOT_FOUND);
	        }

	        bedRepository.delete(bed);
	    }

	@Override
	public void deleteAllBeds() {
		  bedRepository.deleteAll();
		
	}




	@Override
	public List<Integer> getAllDistinctSharing() {
		
		return bedRepository.findAllDistinctSharing();

	}

}
