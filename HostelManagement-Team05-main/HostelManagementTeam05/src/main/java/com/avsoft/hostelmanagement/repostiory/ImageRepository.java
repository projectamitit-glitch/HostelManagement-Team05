package com.avsoft.hostelmanagement.repostiory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.avsoft.hostelmanagement.entity.Image;

public interface ImageRepository extends JpaRepository<Image, Long> {

//	List<Image> findByHostelHostelId(Long hostelId);
//	public List<Image> findByhostelId(Long hostelId);
	List<Image>  findTop5ByOrderByIdDesc();
	
	}
