package com.sorb.testproject.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class PersonInfoDTO {

    //person info
    private String gender;

    private String title;

    private String firstName;

    private String lastName;

    private String email;

    private LocalDateTime dateOfBirth;

    private int age;

    private LocalDateTime registrationDate;

    private int registrationAge;

    private String nationality;


}
