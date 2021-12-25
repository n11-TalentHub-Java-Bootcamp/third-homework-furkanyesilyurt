package com.furkanyesilyurt.mongodbstudy.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ProductCommentNotFoundException extends RuntimeException {

    public ProductCommentNotFoundException(String message) {
        super(message);
    }

}
