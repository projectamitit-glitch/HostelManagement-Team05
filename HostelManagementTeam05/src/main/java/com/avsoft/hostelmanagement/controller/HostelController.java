package com.avsoft.hostelmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.avsoft.hostelmanagement.constants.MessageConstant;
import com.avsoft.hostelmanagement.dto.HostelDto;
import com.avsoft.hostelmanagement.entity.Hostel;
import com.avsoft.hostelmanagement.response.ApiResponse;
import com.avsoft.hostelmanagement.response.PaginationResponse;
import com.avsoft.hostelmanagement.service.HostelService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class HostelController {
	@Autowired
	HostelService hostelService;

	@PostMapping("/hostel")
	public ResponseEntity<ApiResponse<Hostel>> postHostel(@RequestBody HostelDto hostelDto) {

		Hostel hos = hostelService.saveHostel(hostelDto);

		return new ResponseEntity<>(new ApiResponse<>(MessageConstant.HOSTEL_CREATED_SUCCESS, hos), HttpStatus.CREATED);
	}

	@GetMapping("/getHostel/{id}")
	public ResponseEntity<ApiResponse<Hostel>> getbyId(@PathVariable long id) {
		Hostel hostel = hostelService.getHostelById(id);
		return new ResponseEntity<>(new ApiResponse<>(MessageConstant.HOSTEL_FETCH_SUCCESS, hostel), HttpStatus.OK);
	}

	@GetMapping("/getAllforHostel")
	public ResponseEntity<ApiResponse<PaginationResponse<Hostel>>> getAll(
			@RequestParam(value = "pageNumber", defaultValue = "0") Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize) {

		PaginationResponse<Hostel> postResponse = hostelService.getHostel(pageNumber, pageSize);

		return new ResponseEntity<>(new ApiResponse<>(MessageConstant.HOSTEL_LIST_FETCH_SUCCESS, postResponse),
				HttpStatus.OK);
	}

	@DeleteMapping("/deleteHostel/{id}")
	public ResponseEntity<ApiResponse<String>> deleteHostel(@PathVariable Long id) {
		hostelService.deleteHostel(id);
		return new ResponseEntity<>(new ApiResponse<>(MessageConstant.HOSTEL_DELETE_SUCCESS, null),
				HttpStatus.NO_CONTENT);
	}

	@DeleteMapping("/deleteAllHostel")
	public ResponseEntity<ApiResponse<String>> deleteAll() {
		hostelService.deleteAllHostel();
		return new ResponseEntity<>(new ApiResponse<>(MessageConstant.HOSTEL_DELETE_ALL_SUCCESS, null),
				HttpStatus.NO_CONTENT);
	}

}
