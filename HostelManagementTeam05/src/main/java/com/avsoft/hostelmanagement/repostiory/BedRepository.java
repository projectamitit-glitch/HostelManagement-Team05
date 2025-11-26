package com.avsoft.hostelmanagement.repostiory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.avsoft.hostelmanagement.entity.Bed;

public interface BedRepository extends JpaRepository<Bed, Long>{
	List<Bed> findByRoomId(Long roomId);
}
