package com.avsoft.hostelmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.avsoft.hostelmanagement.dto.ImageDto;
import com.avsoft.hostelmanagement.entity.Image;
import com.avsoft.hostelmanagement.response.ApiResponse;
import com.avsoft.hostelmanagement.service.ImageService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/image")
public class ImageController {
	
	@Autowired
	ImageService imageService;
	
	@PostMapping("/save/{hostelId}")
	public ResponseEntity<ApiResponse<ImageDto>> saveImage(@PathVariable Long hostelId,@RequestParam("file") MultipartFile file) throws Exception {

	    ImageDto saved = imageService.addImage(hostelId, file);

	    return new ResponseEntity<>(
	            new ApiResponse<>("Image uploaded successfully!", saved),
	            HttpStatus.CREATED
	    );	
	}
	
	@GetMapping("/get/{hostelId}")
	public ResponseEntity<List<ImageDto>> getImageByHostelId(@PathVariable Long hostelId) throws Exception {
	    return ResponseEntity.ok(imageService.getImageByhid(hostelId));
	}
	
	@GetMapping("/getTop5")
	public ResponseEntity<List<ImageDto>> Top5Images() {
	    return ResponseEntity.ok(imageService.getTop5Image());
	}
	
	 @DeleteMapping("/delete/{id}")
	    public ResponseEntity<ApiResponse<String>> deleteImage(@PathVariable Long id) {

	        imageService.deleteById(id);

	        return new ResponseEntity<>(
	                new ApiResponse<>("Image deleted successfully!", "Deleted"),
	                HttpStatus.OK
	        );
	 } 
	 
	 @GetMapping("/{id}")
	    public ResponseEntity<ApiResponse<Image>> getImageById(@PathVariable Long id) {

	        Image img = imageService.getImageByid(id);

	        return new ResponseEntity<>(
	                new ApiResponse<>("Image fetched successfully!", img),
	                HttpStatus.OK
	        );
	    }
	 @GetMapping("/getAll")
	    public ResponseEntity<ApiResponse<List<Image>>> getAllImages() {

	        List<Image> list = imageService.getImages();

	        return new ResponseEntity<>(
	                new ApiResponse<>("Images fetched successfully!", list),
	                HttpStatus.OK
	        );
	    }

}


