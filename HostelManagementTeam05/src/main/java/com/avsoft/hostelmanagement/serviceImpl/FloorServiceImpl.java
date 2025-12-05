package com.avsoft.hostelmanagement.serviceImpl;

<<<<<<< HEAD
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.avsoft.hostelmanagement.dto.FloorDto;
import com.avsoft.hostelmanagement.dto.GetFloorDto;
import com.avsoft.hostelmanagement.entity.Building;
import com.avsoft.hostelmanagement.entity.Floor;
import com.avsoft.hostelmanagement.exceptionHandler.FloorServiceException;
import com.avsoft.hostelmanagement.repostiory.BuildingRepository;
import com.avsoft.hostelmanagement.repostiory.FloorRepository;
import com.avsoft.hostelmanagement.service.FloorService;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Service

@Slf4j
public class FloorServiceImpl implements FloorService {

    @Autowired
    FloorRepository floorRepo;

    @Autowired
   BuildingRepository buildingRepo;

    @Override
    public void addFloor(Long buildingId, FloorDto floorDto) {

        Building building = buildingRepo.findById(buildingId).orElseThrow(() ->
                new FloorServiceException(
                        "Building ID not found: " + buildingId,
                        HttpStatus.NOT_FOUND
                )
        );

        Floor floor = new Floor();
        floor.setFloorNo(floorDto.getFloorNo());
        floor.setNoOfRooms(floorDto.getNoOfRooms());
        floor.setFloorType(floorDto.getFloorType());
        floor.setStatus(floorDto.getStatus());
        floor.setBuilding(building);

        try {
            floorRepo.save(floor);
        } catch (Exception e) {
            throw new FloorServiceException(
                    "Error occurred while saving the floor.",
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }
    }

    @Override
    public FloorDto getFloorById(Long id) {

        Floor floor = floorRepo.findById(id).orElseThrow(() ->
                new FloorServiceException(
                        "Floor ID not found: " + id,
                        HttpStatus.NOT_FOUND
                )
        );

        FloorDto dto = new FloorDto();
        dto.setId(floor.getId());
        dto.setFloorNo(floor.getFloorNo());
        dto.setNoOfRooms(floor.getNoOfRooms());
        dto.setFloorType(floor.getFloorType());
        dto.setStatus(floor.getStatus());

        dto.setBuildingName(floor.getBuilding().getName());
        dto.setHostelName(floor.getBuilding().getHostel().getName());
        dto.setOrgName(floor.getBuilding().getHostel().getOrganization().getOrgName());

        return dto;
    }

    @Override
    public List<FloorDto> getFloorByBuildingId(Long buildingId) {

        Building building = buildingRepo.findById(buildingId).orElseThrow(() ->
                new FloorServiceException(
                        "Building ID not found: " + buildingId,
                        HttpStatus.NOT_FOUND
                )
        );

        List<FloorDto> dtoList = new ArrayList<>();

        for (Floor floor : building.getFloorsList()) {

            FloorDto dto = new FloorDto();
            dto.setId(floor.getId());
            dto.setFloorNo(floor.getFloorNo());
            dto.setNoOfRooms(floor.getNoOfRooms());
            dto.setFloorType(floor.getFloorType());
            dto.setStatus(floor.getStatus());

            dto.setBuildingName(building.getName());
            dto.setHostelName(building.getHostel().getName());
            dto.setOrgName(building.getHostel().getOrganization().getOrgName());

            dtoList.add(dto);
        }

        return dtoList;
    }

    @Override
    public List<FloorDto> getAllFloors() {

        List<Floor> floors = floorRepo.findAll();
        List<FloorDto> dtoList = new ArrayList<>();

        for (Floor floor : floors) {

            FloorDto dto = new FloorDto();
            dto.setId(floor.getId());
            dto.setFloorNo(floor.getFloorNo());
            dto.setNoOfRooms(floor.getNoOfRooms());
            dto.setFloorType(floor.getFloorType());
            dto.setStatus(floor.getStatus());

            dto.setBuildingName(floor.getBuilding().getName());
            dto.setHostelName(floor.getBuilding().getHostel().getName());
            dto.setOrgName(floor.getBuilding().getHostel().getOrganization().getOrgName());

            dtoList.add(dto);
        }

        return dtoList;
    }

    @Override
    public void deleteFloorById(Long floorId) {

        Floor floor = floorRepo.findById(floorId)
                .orElseThrow(() ->
                        new FloorServiceException(
                                "Floor ID not found: " + floorId,
                                HttpStatus.NOT_FOUND
                        )
                );

        floorRepo.delete(floor);
    }
}
=======
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avsoft.hostelmanagement.entity.Building;
import com.avsoft.hostelmanagement.entity.Floor;
import com.avsoft.hostelmanagement.entity.Room;
import com.avsoft.hostelmanagement.repostiory.BuildingRepository;
import com.avsoft.hostelmanagement.repostiory.FloorRepository;
import com.avsoft.hostelmanagement.service.FloorService;

@Service
public class FloorServiceImpl implements FloorService {

    @Autowired
    private FloorRepository floorRepository;

    @Autowired
    private BuildingRepository buildingRepository;

    @Override
    public Floor saveFloor(Floor floor, Long buildingId) {

        Building building = buildingRepository.findById(buildingId).orElseThrow(() -> new RuntimeException("Building not found with id: " + buildingId));

        floor.setBuilding(building);

        if (floor.getRooms() != null) {
            for (Room r : floor.getRooms()) {
                r.setFloor(floor);
            }
        }

        return floorRepository.save(floor);
        
    }

    @Override
    public List<Floor> saveAllFloors(List<Floor> floors, Long buildingId) {

        Building building = buildingRepository.findById(buildingId).orElseThrow(() -> new RuntimeException("Building not found with id: " + buildingId));

        for (Floor floor : floors) {
            floor.setBuilding(building);

            if (floor.getRooms() != null) {
                for (Room room : floor.getRooms()) {
                    room.setFloor(floor);
                }
            }
        }

        return floorRepository.saveAll(floors);
        
    }

    @Override
    public Floor getFloorById(Long id) {
    	
        return floorRepository.findById(id).orElseThrow(() -> new RuntimeException("Floor not found with id: " + id));
        
    }

    @Override
    public List<Floor> getAllFloors() {
    	
        return floorRepository.findAll();
        
    }

    @Override
    public List<Floor> getFloorByRoomCount(int noOfRooms) {
    	
        return floorRepository.findByNoOfRooms(noOfRooms);
        
    }

}

>>>>>>> remotes/origin/feature/samiksha/#11
