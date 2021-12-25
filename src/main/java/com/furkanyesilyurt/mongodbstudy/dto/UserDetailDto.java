package com.furkanyesilyurt.mongodbstudy.dto;

import lombok.Data;

@Data
public class UserDetailDto {

    private String firstName;
    private String lastName;
    private String emailAdress;
    private String phoneNumber;
    private String userId;
}
