package com.avsoft.hostelmanagement.repostiory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.avsoft.hostelmanagement.entity.Building;

public interface BuildingRepository extends JpaRepository<Building, Long>{

	List<Building> findByName(String name);

	List<Building> findById(String warden);

}
