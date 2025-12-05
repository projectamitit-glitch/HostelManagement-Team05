package com.avsoft.hostelmanagement.repostiory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.avsoft.hostelmanagement.entity.Bed;

public interface BedRepository extends JpaRepository<Bed, Long>{

	List<Bed> findByStatusAndSharing(String status, int sharing);

	List<Bed> findBySharingAndRoom_Hostel_Id(int sharing, Long hostelId);
	
}
