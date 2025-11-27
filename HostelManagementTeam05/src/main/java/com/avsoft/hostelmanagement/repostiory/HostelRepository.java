package com.avsoft.hostelmanagement.repostiory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.avsoft.hostelmanagement.entity.Hostel;

public interface HostelRepository extends JpaRepository<Hostel, Long>{

}
