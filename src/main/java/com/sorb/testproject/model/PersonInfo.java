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

    @OneToOne(mappedBy = "personInfo")
    private PersonLogin personLogin;

    @OneToOne(mappedBy = "personInfo")
    private Location location;

    @ManyToOne
    @JoinColumn(name = "person_info_id")
    private Timezone timezone;

    @OneToOne(mappedBy = "personInfo")
    private PersonContacts personContacts;

    @OneToOne(mappedBy = "personInfo")
    private PersonId personId;

    @OneToOne(mappedBy = "personInfo")
    private PersonPictures personPictures;
}
