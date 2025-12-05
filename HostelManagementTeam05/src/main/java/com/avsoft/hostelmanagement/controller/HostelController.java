package com.avsoft.hostelmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
<<<<<<< HEAD
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
=======
import org.springframework.http.ResponseEntity;
>>>>>>> remotes/origin/feature/samiksha/#11
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

<<<<<<< HEAD
import com.avsoft.hostelmanagement.util.MessageConstant;
import com.avsoft.hostelmanagement.dto.HostelDto;
import com.avsoft.hostelmanagement.entity.Hostel;
import com.avsoft.hostelmanagement.response.ApiResponse;
import com.avsoft.hostelmanagement.service.HostelService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/hostel")
public class HostelController {
	@Autowired
	HostelService hostelService;

	@PostMapping("/hostel")
	public ResponseEntity<ApiResponse<Hostel>> postHostel(@RequestBody HostelDto hostelDto) {

	    Hostel hos = hostelService.saveHostel(hostelDto);

	    return new ResponseEntity<>(
	            new ApiResponse<>(MessageConstant.HOSTEL_CREATED_SUCCESS, hos),
	            HttpStatus.CREATED
	    );
	}

	@GetMapping("/hostel/{id}")
	public ResponseEntity<ApiResponse<Hostel>> getbyId(@PathVariable long id) {
	    Hostel hostel = hostelService.getHostelById(id);
	    return new ResponseEntity<>(
	            new ApiResponse<>(MessageConstant.HOSTEL_FETCH_SUCCESS, hostel),
	            HttpStatus.OK
	    );
	}

	@GetMapping("/allhostel")
	public ResponseEntity<ApiResponse<List<Hostel>>> getAll() {
	    List<Hostel> list = hostelService.getHostel();
	    return new ResponseEntity<>(
	            new ApiResponse<>(MessageConstant.HOSTEL_LIST_FETCH_SUCCESS, list),
	            HttpStatus.OK
	    );
	}

	@DeleteMapping("/hostel/{id}")
	public ResponseEntity<ApiResponse<String>> deleteHostel(@PathVariable Long id){
	    hostelService.deleteHostel(id);
	    return new ResponseEntity<>(
	            new ApiResponse<>(MessageConstant.HOSTEL_DELETE_SUCCESS, null),
	            HttpStatus.NO_CONTENT
	    );
	}

	@DeleteMapping("/allhostel")
	public ResponseEntity<ApiResponse<String>> deleteAll(){
	    hostelService.deleteAllHostel();
	    return new ResponseEntity<>(
	            new ApiResponse<>(MessageConstant.HOSTEL_DELETE_ALL_SUCCESS, null),
	            HttpStatus.NO_CONTENT
	    );
	}


}
=======
import com.avsoft.hostelmanagement.entity.Hostel;
import com.avsoft.hostelmanagement.service.HostelService;

@RestController
@RequestMapping("/hostels")
public class HostelController {

    @Autowired
    private HostelService hostelService;

    @PostMapping("/add/{orgId}")
    public ResponseEntity<Hostel> addHostel(@RequestBody Hostel hostel, @PathVariable Long orgId) {

        Hostel saved = hostelService.saveHostel(hostel, orgId);
        return ResponseEntity.ok(saved);
        
    }

    @PostMapping("/add-multiple/{orgId}")
    public ResponseEntity<List<Hostel>> addMultiple(@RequestBody List<Hostel> hostels, @PathVariable Long orgId) {

        return ResponseEntity.ok(hostelService.saveAllHostels(hostels, orgId));
        
    }

    @GetMapping("/{id}")
    public ResponseEntity<Hostel> getHostel(@PathVariable Long id) {
    	
        return ResponseEntity.ok(hostelService.getHostelById(id));
        
    }

    @GetMapping("/all")
    public ResponseEntity<List<Hostel>> getAll() {
    	
        return ResponseEntity.ok(hostelService.getAllHostels());
        
    }
}

>>>>>>> remotes/origin/feature/samiksha/#11
