package com.sorb.testproject.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table
@Getter
@Setter
@ToString
public class PersonContacts {

    @Id
    @GeneratedValue
    private int id;

    @Column
    private String phone;

    @Column
    private String cell;

}
