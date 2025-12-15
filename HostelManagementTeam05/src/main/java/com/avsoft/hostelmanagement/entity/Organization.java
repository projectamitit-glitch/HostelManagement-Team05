package com.avsoft.hostelmanagement.entity;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Organization {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;

	private String orgName;
	private String address;
	private String email;
	private String contactNo;
	private String website;
	private String gstNo;
	private String logoUrl;

	private String status;
	private LocalDate createdAt;
	private LocalDate updatedAt;

	@OneToMany(mappedBy = "organization", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Hostel> hostels;
}
