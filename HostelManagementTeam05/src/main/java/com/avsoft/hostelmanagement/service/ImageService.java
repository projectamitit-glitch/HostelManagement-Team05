package com.avsoft.hostelmanagement.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.avsoft.hostelmanagement.dto.ImageDto;
import com.avsoft.hostelmanagement.entity.Image;

public interface ImageService {
	public ImageDto addImage(Long hostelId,MultipartFile file)throws Exception;
	public List<ImageDto> getImageByhid(Long hostelId);
	public List<ImageDto> getTop5Image();
	public List<Image> getImages();
	public Image getImageByid(Long id);
	public void deleteById(Long id);
	
	
}
