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
public class Hostel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String address;
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
    private List<Building> buildings;

    @ManyToOne
    @JoinColumn(name = "organization_id")
    private Organization organization;
}
