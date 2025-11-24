package com.avsoft.hostelmanagement.repostiory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.avsoft.hostelmanagement.entity.Room;

public interface RoomEntity extends JpaRepository<Room, Long>{

}
