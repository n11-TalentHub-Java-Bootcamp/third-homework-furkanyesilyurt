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
