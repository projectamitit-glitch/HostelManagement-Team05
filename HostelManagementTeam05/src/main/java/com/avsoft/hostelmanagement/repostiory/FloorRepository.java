package com.avsoft.hostelmanagement.repostiory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.avsoft.hostelmanagement.entity.Floor;

public interface FloorRepository extends JpaRepository<Floor, Long>{

	List<Floor> findByNoOfRooms(int noOfRooms);

}
