package com.avsoft.hostelmanagement.repostiory;

<<<<<<< HEAD
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.avsoft.hostelmanagement.entity.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long>{
	List<Room> findByFloorId(Long floorId);
=======
import org.springframework.data.jpa.repository.JpaRepository;

import com.avsoft.hostelmanagement.entity.Room;

public interface RoomRepository extends JpaRepository<Room, Long>{

>>>>>>> remotes/origin/feature/samiksha/#11
}
