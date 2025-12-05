package com.avsoft.hostelmanagement.controller;

<<<<<<< HEAD
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.avsoft.hostelmanagement.util.MessageConstant;
import com.avsoft.hostelmanagement.dto.FloorDto;
import com.avsoft.hostelmanagement.response.ApiResponse;
import com.avsoft.hostelmanagement.service.FloorService;

import java.util.List;

=======
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.avsoft.hostelmanagement.entity.Floor;
import com.avsoft.hostelmanagement.service.FloorService;

>>>>>>> remotes/origin/feature/samiksha/#11
@RestController
@RequestMapping("/floor")
public class FloorController {

<<<<<<< HEAD
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

	
	public ResponseEntity<ApiResponse<List<FloorDto>>> getAllFloors() {

		List<FloorDto> floors = floorService.getAllFloors();

		return new ResponseEntity<>(new ApiResponse<>(MessageConstant.FLOOR_LIST_FETCH_SUCCESS, floors), HttpStatus.OK);
	}


	@GetMapping("/floor/{buildingId}")
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
=======
    @Autowired
    private FloorService floorService;

    @PostMapping("/add/{buildingId}")
    public ResponseEntity<Floor> addFloor(@RequestBody Floor floor, @PathVariable Long buildingId) {
    	
        return ResponseEntity.ok(floorService.saveFloor(floor, buildingId));
        
    }

    @PostMapping("/add-multiple/{buildingId}")
    public ResponseEntity<List<Floor>> addFloors(@RequestBody List<Floor> floors, @PathVariable Long buildingId) {
    	
        return ResponseEntity.ok(floorService.saveAllFloors(floors, buildingId));
        
    }

    @GetMapping("/{id}")
    public ResponseEntity<Floor> getFloor(@PathVariable Long id) {
    	
        return ResponseEntity.ok(floorService.getFloorById(id));
        
    }

    @GetMapping("/all")
    public ResponseEntity<List<Floor>> getAll() {
    	
        return ResponseEntity.ok(floorService.getAllFloors());
        
    }

    @GetMapping("/rooms/{count}")
    public ResponseEntity<List<Floor>> getFloorsByRooms(@PathVariable int count) {
    	
        return ResponseEntity.ok(floorService.getFloorByRoomCount(count));
        
    }
>>>>>>> remotes/origin/feature/samiksha/#11
}
