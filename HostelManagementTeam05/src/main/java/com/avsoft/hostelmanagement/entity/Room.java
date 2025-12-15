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

    private String type;     

    private String status;   

    private Double pricePerBed;

    private Boolean attachedBathroom;

    private Boolean balcony;

    @ManyToOne(fetch = FetchType.LAZY) 
    @JoinColumn(name = "floor_id")
    @JsonIgnore
    private Floor floor;

    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Bed> beds;
}