package com.avsoft.hostelmanagement.repostiory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.avsoft.hostelmanagement.entity.Building;

public interface BuildingRepository extends JpaRepository<Building, Long>{

}
