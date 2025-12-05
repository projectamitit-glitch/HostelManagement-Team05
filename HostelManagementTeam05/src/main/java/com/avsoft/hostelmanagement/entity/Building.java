package com.avsoft.hostelmanagement.entity;

import java.time.LocalDate;
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
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Building {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private int floors;
	private String name;
	private String warden;
	private String contactNo;

	private boolean maintenanceRequired;
	private String status;

	private LocalDate createdAt;
	private LocalDate updatedAt;

	@ManyToOne
	@JoinColumn(name = "hostel_id")
	@JsonIgnore
	private Hostel hostel;

	@OneToMany(mappedBy = "building", cascade = CascadeType.ALL)
	private List<Floor> floorsList;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getFloors() {
		return floors;
	}

	public void setFloors(int floors) {
		this.floors = floors;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getWarden() {
		return warden;
	}

	public void setWarden(String warden) {
		this.warden = warden;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public boolean isMaintenanceRequired() {
		return maintenanceRequired;
	}

	public void setMaintenanceRequired(boolean maintenanceRequired) {
		this.maintenanceRequired = maintenanceRequired;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDate getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDate createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDate getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDate updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Hostel getHostel() {
		return hostel;
	}

	public void setHostel(Hostel hostel) {
		this.hostel = hostel;
	}

	public List<Floor> getFloorsList() {
		return floorsList;
	}

	public void setFloorsList(List<Floor> floorsList) {
		this.floorsList = floorsList;
	}

}
