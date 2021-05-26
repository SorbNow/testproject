package com.sorb.testproject.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table
@Getter
@Setter
@ToString
public class PersonInfo {

    @Id
    @GeneratedValue
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
    private LocalDateTime registrationDate;

    @Column
    private String nationality;

    @OneToOne(mappedBy = "person_info")
    private PersonLogin personLogin;

    @OneToOne(mappedBy = "person_info")
    private Location location;

    @OneToOne(mappedBy = "person_info")
    private Timezone timezone;

    @OneToOne(mappedBy = "person_info")
    private PersonContacts personContacts;

    @OneToOne(mappedBy = "person_info")
    private PersonId personId;

    @OneToOne(mappedBy = "person_info")
    private PersonPictures personPictures;
}
