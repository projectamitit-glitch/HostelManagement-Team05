package com.avsoft.hostelmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.avsoft.hostelmanagement.dto.FloorDto;
import com.avsoft.hostelmanagement.response.ApiResponse;
import com.avsoft.hostelmanagement.service.FloorService;
import com.avsoft.hostelmanagement.util.MessageConstant;

import java.util.List;

@RestController
@RequestMapping("/api/floors")
public class FloorController {

	@Autowired
	private FloorService floorService;

	
	@PostMapping("/{buildingId}")
	public ResponseEntity<ApiResponse<String>> saveFloor(@PathVariable Long buildingId,
			@RequestBody FloorDto floorDto) {

		floorService.addFloor(buildingId, floorDto);

		return new ResponseEntity<>(new ApiResponse<>(MessageConstant.FLOOR_CREATED_SUCCESS, null), HttpStatus.CREATED);
	}

	
	@GetMapping("/{floorId}")
	public ResponseEntity<ApiResponse<FloorDto>> getFloorById(@PathVariable Long floorId) {

		FloorDto dto = floorService.getFloorById(floorId);

		return new ResponseEntity<>(new ApiResponse<>(MessageConstant.FLOOR_FETCH_SUCCESS, dto), HttpStatus.OK);
	}

	
	@GetMapping
	public ResponseEntity<ApiResponse<List<FloorDto>>> getAllFloors() {

		List<FloorDto> floors = floorService.getAllFloors();

		return new ResponseEntity<>(new ApiResponse<>(MessageConstant.FLOOR_LIST_FETCH_SUCCESS, floors), HttpStatus.OK);
	}


	@GetMapping("/building/{buildingId}")
	public ResponseEntity<ApiResponse<List<FloorDto>>> getFloorByBuildingId(@PathVariable Long buildingId) {

		List<FloorDto> floors = floorService.getFloorByBuildingId(buildingId);

		return new ResponseEntity<>(new ApiResponse<>(MessageConstant.FLOOR_BY_BUILDING_FETCH_SUCCESS, floors),
				HttpStatus.OK);
	}

	
	@DeleteMapping("/{floorId}")
	public ResponseEntity<ApiResponse<String>> deleteFloorById(@PathVariable Long floorId) {

		floorService.deleteFloorById(floorId);

		return new ResponseEntity<>(new ApiResponse<>(MessageConstant.FLOOR_DELETE_SUCCESS, null), HttpStatus.OK);
	}
}
