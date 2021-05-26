package com.sorb.testproject.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table
@Data
public class PersonId {

    @Id
    @GeneratedValue
    private int id;

    @Column
    private String name;

    @Column
    private String value;

    @OneToOne
    @JoinColumn(name = "person_info_id")
    private PersonInfo personInfo;
}
