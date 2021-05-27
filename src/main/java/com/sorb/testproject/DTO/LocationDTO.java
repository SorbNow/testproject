package com.sorb.testproject.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LocationDTO {

    private String country;

    private String state;

    private String city;

    private String street;

    private String number;

    private String postcode;

    private String latitude;

    private String longitude;

}
