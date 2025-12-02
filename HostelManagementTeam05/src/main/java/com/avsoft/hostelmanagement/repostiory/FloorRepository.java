package com.avsoft.hostelmanagement.repostiory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.avsoft.hostelmanagement.dto.GetFloorDto;
import com.avsoft.hostelmanagement.entity.Floor;



public interface FloorRepository extends JpaRepository<Floor, Integer>  {

	List<GetFloorDto> findByBuildingId(int id);
}