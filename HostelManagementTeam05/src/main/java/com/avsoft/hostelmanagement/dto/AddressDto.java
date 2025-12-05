package com.avsoft.hostelmanagement.dto;
import lombok.Data;

@Data
public class AddressDto {
    private int id;
    private String area;
    private String city;
    private int zipCode;
    private String state;
    private String country;
}