package com.sorb.testproject.model;

import lombok.Data;

import javax.persistence.*;

@Table
@Entity
@Data
public class Location {

    @Id
    @GeneratedValue
    private int id;

    @Column
    private String country;

    @Column
    private String state;

    @Column
    private String city;

    @Column
    private String street;

    @Column
    private String number;

    @Column
    private String postcode;

    @Column
    private String latitude;

    @Column
    private String longitude;
}
