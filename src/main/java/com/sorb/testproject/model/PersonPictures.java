package com.sorb.testproject.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table
@Data
public class PersonPictures {

    @Id
    @GeneratedValue
    private int id;

    @Column
    private String largePic;

    @Column
    private String mediumPic;

    @Column
    private String thumbnail;
}
