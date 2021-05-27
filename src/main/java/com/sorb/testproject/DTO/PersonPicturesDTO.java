package com.sorb.testproject.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PersonPicturesDTO {
    private String largePic;

    private String mediumPic;

    private String thumbnail;
}
