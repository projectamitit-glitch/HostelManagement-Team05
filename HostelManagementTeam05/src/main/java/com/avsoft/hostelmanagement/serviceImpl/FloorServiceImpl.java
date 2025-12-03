package com.avsoft.hostelmanagement.serviceImpl;

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
@Transactional
@Slf4j
public class FloorServiceImpl implements FloorService {

    @Autowired
    FloorRepository floorRepo;

    @Autowired
    BuildingRepository buildingRepo;

    @Override
    public void addFloor(int buildingId, FloorDto floorDto) {

        Building building = buildingRepo.findById(buildingId).orElseThrow(() ->
                new FloorServiceException(
                        "Building ID not found: " + buildingId,
                        HttpStatus.NOT_FOUND
                )
        );

        Floor floor = new Floor();
        floor.setFloorNo(floorDto.getFloorNo());
        floor.setNoOfRooms(floorDto.getNoOfRooms());
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
    public GetFloorDto getFloorById(int id) {

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
        dto.setBuildingName(floor.getBuilding().getName());
        dto.setHostelName(floor.getBuilding().getHostel().getName());
        dto.setOrgName(floor.getBuilding().getHostel().getOrgnization().getName());

        return dto;
    }

    @Override
    public List<GetFloorDto> getFloorByBuildingId(int buildingId) {

        Building building = buildingRepo.findById(buildingId).orElseThrow(() ->
                new FloorServiceException(
                        "Building ID not found: " + buildingId,
                        HttpStatus.NOT_FOUND
                )
        );

        List<GetFloorDto> dtoList = new ArrayList<>();

        for (Floor floor : building.getFloors()) {
            GetFloorDto dto = new GetFloorDto();
            dto.setId(floor.getId());
            dto.setFloorNo(floor.getFloorNo());
            dto.setNoOfRooms(floor.getNoOfRooms());
            dto.setBuildingName(floor.getBuilding().getName());
            dto.setHostelName(floor.getBuilding().getHostel().getName());
            dto.setOrgName(floor.getBuilding().getHostel().getOrgnization().getName());
            dtoList.add(dto);
        }

        return dtoList;
    }

    @Override
    public List<GetFloorDto> getAllFloors() {

        List<Floor> floors = floorRepo.findAll();
        List<GetFloorDto> dtoList = new ArrayList<>();

        for (Floor floor : floors) {
            GetFloorDto dto = new GetFloorDto();
            dto.setId(floor.getId());
            dto.setFloorNo(floor.getFloorNo());
            dto.setNoOfRooms(floor.getNoOfRooms());
            dto.setBuildingName(floor.getBuilding().getName());
            dto.setHostelName(floor.getBuilding().getHostel().getName());
            dto.setOrgName(floor.getBuilding().getHostel().getOrgnization().getName());
            dtoList.add(dto);
        }

        return dtoList;
    }

    @Override
    public void deleteFloorById(int floorId) {

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
