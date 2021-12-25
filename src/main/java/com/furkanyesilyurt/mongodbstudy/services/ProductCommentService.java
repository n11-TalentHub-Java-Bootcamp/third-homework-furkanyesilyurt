package com.furkanyesilyurt.mongodbstudy.services;

import com.furkanyesilyurt.mongodbstudy.dto.ProductCommentDetailDto;
import com.furkanyesilyurt.mongodbstudy.entities.ProductComment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ProductCommentService {

    List<ProductCommentDetailDto> findAll();

    ProductComment findById(String id) ;

    ProductComment save(ProductComment productComment);

    void delete(String id) ;

}
