package com.avsoft.hostelmanagement.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Hostel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;
//	private String address;
	private int capacity;
	private String contactNo;

	private String email;
	private String image;
	private String website;

	private String genderType;
	private String description;

	private double latitude;
	private double longitude;

	private String status;
	private LocalDate createdAt;
	private LocalDate updatedAt;

	@OneToMany(mappedBy = "hostel", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Building> buildings;
	
	
	@OneToMany(mappedBy = "hostel", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Image> images = new ArrayList<>();

	@ManyToOne
	@JoinColumn(name = "organization_id")
	@JsonIgnore
	private Organization organization;

	@OneToOne
	@JoinColumn(name = "address_id")
	@JsonIgnore
	private Address addresss;

}
