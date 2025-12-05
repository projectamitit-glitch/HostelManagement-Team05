package com.avsoft.hostelmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
<<<<<<< HEAD
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
}
=======
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.avsoft.hostelmanagement.entity.Bed;
import com.avsoft.hostelmanagement.service.BedService;

@RestController
@RequestMapping("/beds")
public class BedController {

    @Autowired
    private BedService bedService;

    @PostMapping("/add/{roomId}")
    public ResponseEntity<Bed> addBed(@RequestBody Bed bed, @PathVariable Long roomId) {

        Bed saved = bedService.saveBed(bed, roomId);
        
        return ResponseEntity.ok(saved);
        
    }

    @PostMapping("/addAll/{roomId}")
    public ResponseEntity<List<Bed>> addAllBeds(@RequestBody List<Bed> beds, @PathVariable Long roomId) {

        List<Bed> saved = bedService.saveAllBeds(beds, roomId);
        
        return ResponseEntity.ok(saved);
        
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bed> getBed(@PathVariable Long id) {
    	
        return ResponseEntity.ok(bedService.getBedById(id));
        
    }

    @GetMapping("/available")
    public ResponseEntity<List<Bed>> getAvailable(@RequestParam int sharing, @RequestParam String status) {

        return ResponseEntity.ok(bedService.getAvailableBedsBySharing(sharing, status));
        
    }

    @GetMapping("/vacant")
    public ResponseEntity<List<Bed>> getVacantBeds(@RequestParam int sharing, @RequestParam Long hostelId) {

        return ResponseEntity.ok(bedService.getVacantBedBySharingAndHostel(sharing, hostelId));
        
    }

}

>>>>>>> remotes/origin/feature/samiksha/#11
