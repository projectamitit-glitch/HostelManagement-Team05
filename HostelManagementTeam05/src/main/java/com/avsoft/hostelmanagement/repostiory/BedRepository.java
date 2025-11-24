package com.avsoft.hostelmanagement.repostiory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.avsoft.hostelmanagement.entity.Bed;

public interface BedRepository extends JpaRepository<Bed, Long>{

}
