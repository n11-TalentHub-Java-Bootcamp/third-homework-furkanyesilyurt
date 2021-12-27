package com.furkanyesilyurt.mongodbstudy.dto;

import lombok.Data;

import java.util.Date;

@Data
public class ProductCommentDetailDto {

    private String comment;
    private Date commentDate;
    private String productId;
    private String userId;

}

//DTO can be written in this way with the record keyword.
//The record keyword is included with JDK 14.
/**
 public record class ProductCommentDetailDto(String comment,
                                                Date commentDate,
                                                String productId,
                                                String userId){ }
 */
