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
public class Person {

    @Id
    @GeneratedValue
    private int id;

    @Column
    private String uuid;

    @Column
    private String userName;

    @Column
    private String password;

    @Column
    private String salt;

    @Column
    private String md5;

    @Column
    private String sha1;

    @Column
    private String sha256;

}
