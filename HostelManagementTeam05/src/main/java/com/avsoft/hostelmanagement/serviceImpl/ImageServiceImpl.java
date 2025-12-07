package com.avsoft.hostelmanagement.serviceImpl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.avsoft.hostelmanagement.dto.ImageDto;
import com.avsoft.hostelmanagement.entity.Hostel;
import com.avsoft.hostelmanagement.entity.Image;
import com.avsoft.hostelmanagement.exceptionHandler.HostelServiceExceptionHandler;
import com.avsoft.hostelmanagement.exceptionHandler.ImageServiceException;
import com.avsoft.hostelmanagement.repostiory.HostelRepository;
import com.avsoft.hostelmanagement.repostiory.ImageRepository;
import com.avsoft.hostelmanagement.service.ImageService;

@Service
public class ImageServiceImpl implements ImageService{
	
	@Autowired
	ImageRepository imageRepository;
	
	@Autowired
	HostelRepository hostelRepository;
	@Override
	public ImageDto addImage(Long hostelId, MultipartFile file) throws Exception {

	    Hostel hostel = hostelRepository.findById(hostelId)
	            .orElseThrow(() -> new RuntimeException("Hostel not found"));

	    Image image = new Image();
	    image.setDate(LocalDate.now());
	    image.setFileName(file.getOriginalFilename());
	    image.setFileType(file.getContentType());
	    image.setImage(file.getBytes());
	    image.setHostel(hostel);

	    Image saved = imageRepository.save(image);

	    
	    ImageDto dto = new ImageDto();
	    dto.setId(saved.getId());
	    dto.setDate(saved.getDate());
	    dto.setFileName(saved.getFileName());
	    dto.setFileType(saved.getFileType());
	    dto.setHostelId(hostelId);

	    return dto;
	}
	@Override
	public List<ImageDto> getImageByhid(Long hostelId) {
		Hostel hostel=hostelRepository.findById(hostelId).orElseThrow((() -> new RuntimeException("Hostel not found")));
		
		List<Image> images=hostel.getImages();
		
	      if (images == null || images.isEmpty()) {
	            throw new RuntimeException("No images found for this hostel");
	        }

		
		List<ImageDto> list=new ArrayList<>();
		
		for(Image img:images) {
			
			ImageDto dto=new ImageDto();
			dto.setId(img.getId());
			dto.setDate(img.getDate());
			dto.setFileName(img.getFileName());
			dto.setFileType(img.getFileType());
			dto.setHostelId(hostelId);
			
			list.add(dto);
		}
		return list;
	}
	@Override
	public List<ImageDto> getTop5Image() {
		List<Image> images=imageRepository.findTop5ByOrderByIdDesc();
		
		List<ImageDto> list=new ArrayList<>();
		
		for(Image img:images) {
			ImageDto dto=new ImageDto();
			dto.setId(img.getId());
			dto.setDate(img.getDate());
			dto.setFileName(img.getFileName());
			dto.setFileType(img.getFileType());
			dto.setHostelId(img.getHostel().getId());
			
			list.add(dto);
		}
		
		return list;
	}
	@Override
	public List<Image> getImages() {
		
		return imageRepository.findAll();
	}
	@Override
	public Image getImageByid(Long id) {
		
		return imageRepository.findById(id).get();
	}
	@Override
	public void deleteById(Long id) {
		Image image=imageRepository.findById(id).get();
		
		 if (image == null) {
	            throw new ImageServiceException(HttpStatus.NOT_FOUND,"image not found");
	        }
		
		imageRepository.delete(image);
		
	}
}
