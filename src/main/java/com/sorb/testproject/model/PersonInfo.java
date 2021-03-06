package com.sorb.testproject.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Entity
@Table
@Getter
@Setter
@ToString
public class PersonInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String gender;

    @Column
    private String title;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private String email;

    @Column
    private LocalDateTime dateOfBirth;

    @Column
    private long age;

    @Column
    private LocalDateTime registrationDate;

    @Column
    private long registeredYears;

    @Column
    private String nationality;

    @OneToOne//(mappedBy = "personInfo")
    private PersonLogin personLogin;

    @OneToOne//(mappedBy = "personInfo")
    private Location location;

    @OneToOne//(mappedBy = "personInfo")
    private PersonContacts personContacts;

    @OneToOne//(mappedBy = "personInfo")
    private PersonId personId;

    @OneToOne//(mappedBy = "personInfo")
    private PersonPictures personPictures;

    public long getAge() {
        return ChronoUnit.YEARS.between(this.dateOfBirth,LocalDateTime.now());
    }

    public long getRegisteredYears() {
        return ChronoUnit.YEARS.between(this.registrationDate,LocalDateTime.now());
    }
}
