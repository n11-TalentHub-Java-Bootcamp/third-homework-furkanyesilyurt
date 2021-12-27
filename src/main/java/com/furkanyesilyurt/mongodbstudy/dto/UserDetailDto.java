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

//DTO can be written in this way with the record keyword.
//The record keyword is included with JDK 14.
/**
public record class UserDetailDtos(String firstName,
                                   String lastName,
                                   String emailAdress,
                                   String phoneNumber,
                                   String userId){ }
*/
