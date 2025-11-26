package com.avsoft.hostelmanagement.repostiory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.avsoft.hostelmanagement.entity.Hostel;

public interface HostelRepository extends JpaRepository<Hostel, Long>{
	List<Hostel> findByOrganizationId(Long organizationId);
}
