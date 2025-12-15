package com.avsoft.hostelmanagement.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.avsoft.hostelmanagement.dto.BedDto;
import com.avsoft.hostelmanagement.entity.Bed;
import com.avsoft.hostelmanagement.entity.Room;
import com.avsoft.hostelmanagement.exceptionHandler.BedException;
import com.avsoft.hostelmanagement.repostiory.BedRepository;
import com.avsoft.hostelmanagement.repostiory.RoomRepository;
import com.avsoft.hostelmanagement.response.PaginationResponse;
import com.avsoft.hostelmanagement.service.BedService;

@Service
public class BedServiceImpl implements BedService {

    @Autowired
    private BedRepository bedRepository;

    @Autowired
    private RoomRepository roomRepository;

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
        return bedRepository.findById(id)
                .orElseThrow(() -> new BedException("Bed not found with id: " + id, HttpStatus.NOT_FOUND));
    }

   
    @Override
    public PaginationResponse<Bed> getAllBeds(Integer pageNumber, Integer pageSize) {

        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        Page<Bed> pageBed = bedRepository.findAll(pageable);

        PaginationResponse<Bed> postResponse = new PaginationResponse<>();
        postResponse.setContent(pageBed.getContent());
        postResponse.setPageNumber(pageBed.getNumber());
        postResponse.setPageSize(pageBed.getSize());
        postResponse.setTotalElements(pageBed.getTotalElements());
        postResponse.setTotalPages(pageBed.getTotalPages());
        postResponse.setLastPage(pageBed.isLast());

        return postResponse;
    }


    @Override
    public void deleteBed(Long id) {
        Bed bed = bedRepository.findById(id)
                .orElseThrow(() -> new BedException("Bed not found with id: " + id, HttpStatus.NOT_FOUND));

        bedRepository.delete(bed);
    }

    @Override
    public void deleteAllBeds() {
        bedRepository.deleteAll();
    }
}

