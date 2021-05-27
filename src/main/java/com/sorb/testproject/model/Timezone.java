package com.sorb.testproject.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(uniqueConstraints = {
        @UniqueConstraint(columnNames = {"timezoneOffset", "description"}),
})
@Data
public class Timezone {

    @Id
    @GeneratedValue
    private int id;

    @Column
    private String timezoneOffset;

    @Column
    private String description;

    @OneToMany(mappedBy = "timezone")
    private List<PersonInfo> personInfo;

}
