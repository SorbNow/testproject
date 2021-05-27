package com.sorb.testproject.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PersonLoginDTO {
    private String uuid;

    private String userName;

    private String password;

    private String salt;

    private String md5;

    private String sha1;

    private String sha256;
}
