package com.avsoft.hostelmanagement.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int roomNo;

    private String type;     // SINGLE, DOUBLE, etc.

    private String status;   // AVAILABLE, FILLED

    private Double pricePerBed;

    private Boolean attachedBathroom;

    private Boolean balcony;

    @ManyToOne(fetch = FetchType.LAZY) // Lazy loading is better for performance
    @JoinColumn(name = "floor_id")
    @JsonIgnore
    private Floor floor;

    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL)
    private List<Bed> beds;
}