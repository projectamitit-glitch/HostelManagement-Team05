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

<<<<<<< HEAD
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
    private List<Bed> beds;
}
=======
	private int roomNo;
	private String type; // SINGLE / DOUBLE / TRIPLE

	private String status; // AVAILABLE / FULL / MAINTENANCE

	private double pricePerBed;
	private boolean attachedBathroom;
	private boolean balcony;

	@ManyToOne
	@JoinColumn(name = "floor_id")
	@JsonIgnore
	private Floor floor;

	@OneToMany(mappedBy = "room", cascade = CascadeType.ALL)
	private List<Bed> beds;

	@ManyToOne
	private Hostel hostel;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getRoomNo() {
		return roomNo;
	}

	public void setRoomNo(int roomNo) {
		this.roomNo = roomNo;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public double getPricePerBed() {
		return pricePerBed;
	}

	public void setPricePerBed(double pricePerBed) {
		this.pricePerBed = pricePerBed;
	}

	public boolean isAttachedBathroom() {
		return attachedBathroom;
	}

	public void setAttachedBathroom(boolean attachedBathroom) {
		this.attachedBathroom = attachedBathroom;
	}

	public boolean isBalcony() {
		return balcony;
	}

	public void setBalcony(boolean balcony) {
		this.balcony = balcony;
	}

	public Floor getFloor() {
		return floor;
	}

	public void setFloor(Floor floor) {
		this.floor = floor;
	}

	public List<Bed> getBeds() {
		return beds;
	}

	public void setBeds(List<Bed> beds) {
		this.beds = beds;
	}

	public Hostel getHostel() {
		return hostel;
	}

	public void setHostel(Hostel hostel) {
		this.hostel = hostel;
	}

}
>>>>>>> remotes/origin/feature/samiksha/#11
