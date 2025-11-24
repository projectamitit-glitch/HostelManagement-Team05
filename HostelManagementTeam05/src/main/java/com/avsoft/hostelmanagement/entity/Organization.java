package com.avsoft.hostelmanagement.entity;

import java.time.LocalDate;
import java.util.List;

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
@Builder
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

    private String status; // ACTIVE / INACTIVE
    private LocalDate createdAt;
    private LocalDate updatedAt;

	/*
	 * @ManyToOne
	 * 
	 * @JoinColumn(name = "owner_id") private Owner owner;
	 */

    @OneToMany(mappedBy = "organization", cascade = CascadeType.ALL)
    private List<Hostel> hostels;
}
