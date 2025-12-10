package com.avsoft.hostelmanagement.controller;

import java.util.List;

import com.avsoft.hostelmanagement.dto.VacantBedDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.avsoft.hostelmanagement.util.MessageConstant;
import com.avsoft.hostelmanagement.dto.BedDto;
import com.avsoft.hostelmanagement.entity.Bed;
import com.avsoft.hostelmanagement.response.ApiResponse;
import com.avsoft.hostelmanagement.service.BedService;

@RestController
@RequestMapping("/api/beds")
public class BedController {

	@Autowired
	BedService bedService;


	@PostMapping("/{roomId}")
	public ResponseEntity<ApiResponse<Bed>> saveBed(@PathVariable Long roomId, @RequestBody BedDto dto) {

		Bed savedBed = bedService.saveBed(roomId, dto);

		return new ResponseEntity<>(new ApiResponse<>(MessageConstant.BED_CREATED_SUCCESS, savedBed),
				HttpStatus.CREATED);
	}


	@GetMapping("/{id}")
	public ResponseEntity<ApiResponse<Bed>> getBed(@PathVariable Long id) {

		Bed bed = bedService.getBedById(id);

		return new ResponseEntity<>(new ApiResponse<>(MessageConstant.BED_FETCH_SUCCESS, bed), HttpStatus.OK);
	}

	
	@GetMapping
	public ResponseEntity<ApiResponse<List<Bed>>> getAllBeds() {

		List<Bed> beds = bedService.getAllBeds();

		return new ResponseEntity<>(new ApiResponse<>(MessageConstant.BED_LIST_FETCH_SUCCESS, beds), HttpStatus.OK);
	}

	
	@DeleteMapping("/{id}")
	public ResponseEntity<ApiResponse<String>> deleteBed(@PathVariable Long id) {

		bedService.deleteBed(id);

		return new ResponseEntity<>(new ApiResponse<>(MessageConstant.BED_DELETE_SUCCESS, null), HttpStatus.OK);
	}

	
	@DeleteMapping("/deleteAll")
	public ResponseEntity<ApiResponse<String>> deleteAllBeds() {

		bedService.deleteAllBeds();

		return new ResponseEntity<>(new ApiResponse<>(MessageConstant.BED_DELETE_ALL_SUCCESS, null), HttpStatus.OK);
	}

    @GetMapping("/{hostel_id}/vacant-beds")
    public List<VacantBedDto> getVacantBeds(@PathVariable Long hostel_id, @RequestParam int sharing){
        System.out.println("Sharing"+sharing);

        return bedService.getVacantBedDetails(hostel_id, sharing);

    }

}
