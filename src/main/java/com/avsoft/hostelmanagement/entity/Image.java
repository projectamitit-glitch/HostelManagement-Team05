package com.avsoft.hostelmanagement.entity;

import java.sql.Types;
import java.time.LocalDate;

import org.hibernate.annotations.JdbcTypeCode;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import lombok.Data;
@Data
@Entity
public class Image {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Long id;
	private LocalDate date;
	
	@Lob
	@Basic(fetch = FetchType.LAZY)
	@JdbcTypeCode(Types.BINARY)
	private byte[] image;
	
	 private String fileName;
	 private String fileType;
	
	 @ManyToOne
	 @JoinColumn(name = "hostel_id")
	 private Hostel hostel;

}
