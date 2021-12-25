package com.furkanyesilyurt.mongodbstudy.services;

import com.furkanyesilyurt.mongodbstudy.dto.ProductCommentDetailDto;
import com.furkanyesilyurt.mongodbstudy.entities.ProductComment;
import com.furkanyesilyurt.mongodbstudy.services.entityServices.ProductCommentEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductCommentServiceImpl implements ProductCommentService{

    //@Autowired
    private final ProductCommentEntityService productCommentEntityService;

    @Override
    public List<ProductCommentDetailDto> findAll() {
        return productCommentEntityService.findAll();
    }

    @Override
    public ProductComment findById(String id) {
        return productCommentEntityService.findById(id);
    }

    @Override
    public ProductComment save(ProductComment productComment) {
        return productCommentEntityService.save(productComment);
    }

    @Override
    public void delete(String id) {
        productCommentEntityService.deleteById(id);
    }
}
