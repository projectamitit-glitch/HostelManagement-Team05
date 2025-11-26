package com.avsoft.hostelmanagement.repostiory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.avsoft.hostelmanagement.entity.Room;

public interface RoomRepository extends JpaRepository<Room, Long>{
	List<Room> findByFloorId(Long floorId);
}
