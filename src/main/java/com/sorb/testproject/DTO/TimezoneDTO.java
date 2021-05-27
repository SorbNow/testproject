package com.sorb.testproject.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TimezoneDTO {
    private String timezoneOffset;

    private String description;
}
