package com.avsoft.hostelmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
<<<<<<< HEAD
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
=======
import org.springframework.http.ResponseEntity;
>>>>>>> remotes/origin/feature/samiksha/#11
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

<<<<<<< HEAD
import com.avsoft.hostelmanagement.util.MessageConstant;
import com.avsoft.hostelmanagement.dto.OrganizationDto;
import com.avsoft.hostelmanagement.entity.Organization;
import com.avsoft.hostelmanagement.response.ApiResponse;
=======
import com.avsoft.hostelmanagement.entity.Organization;
>>>>>>> remotes/origin/feature/samiksha/#11
import com.avsoft.hostelmanagement.service.OrganizationService;

@RestController
@RequestMapping("/organization")
public class OrganizationController {

<<<<<<< HEAD
   
	@Autowired
	OrganizationService organizationService;
	
	@PostMapping("/org")
	public ResponseEntity<ApiResponse<Organization>> saveOrganization(@RequestBody OrganizationDto dto){
	    Organization saved = organizationService.saveOrganization(dto);
	    return new ResponseEntity<>(
	            new ApiResponse<>(MessageConstant.ORG_CREATED_SUCCESS, saved),
	            HttpStatus.CREATED
	    );
	}

	@GetMapping("/org/{id}")
	public ResponseEntity<ApiResponse<Organization>> getOrganizationById(@PathVariable Long id){
	    Organization org = organizationService.getOrganizationById(id);
	    return new ResponseEntity<>(
	            new ApiResponse<>(MessageConstant.ORG_FETCH_SUCCESS, org),
	            HttpStatus.OK
	    );
	}

	@GetMapping("/org")
	public ResponseEntity<ApiResponse<List<Organization>>> getAllOrganization(){
	    List<Organization> list = organizationService.getAllOrganizations();
	    return new ResponseEntity<>(
	            new ApiResponse<>(MessageConstant.ORG_LIST_FETCH_SUCCESS, list),
	            HttpStatus.OK
	    );
	}

	@DeleteMapping("/org/{id}")
	public ResponseEntity<ApiResponse<String>> deleteOrganization(@PathVariable Long id){
	    organizationService.deleteOrganization(id);
	    return new ResponseEntity<>(
	            new ApiResponse<>(MessageConstant.ORG_DELETE_SUCCESS, null),
	            HttpStatus.NO_CONTENT
	    );
	}


=======
    @Autowired
    private OrganizationService organizationService;

    @PostMapping("/add")
    public ResponseEntity<Organization> add(@RequestBody Organization organization) {
    	
        return ResponseEntity.ok(organizationService.addOrganization(organization));
        
    }

    @PostMapping("/add-multiple")
    public ResponseEntity<List<Organization>> addMultiple(@RequestBody List<Organization> organizations) {
    	
        return ResponseEntity.ok(organizationService.addOrganizations(organizations));
        
    }

    @GetMapping("/all")
    public ResponseEntity<List<Organization>> getAll() {
    	
        return ResponseEntity.ok(organizationService.getAllOrganizations());
        
    }

    @GetMapping("/{id}")
    public ResponseEntity<Organization> getById(@PathVariable Long id) {
    	
        return ResponseEntity.ok(organizationService.getOrganizationById(id));
        
    }
>>>>>>> remotes/origin/feature/samiksha/#11
}
