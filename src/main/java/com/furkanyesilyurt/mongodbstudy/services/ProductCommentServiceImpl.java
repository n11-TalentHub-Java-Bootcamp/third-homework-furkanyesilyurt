package com.furkanyesilyurt.mongodbstudy.services;

import com.furkanyesilyurt.mongodbstudy.entities.ProductComment;
import com.furkanyesilyurt.mongodbstudy.services.entityServices.ProductCommentEntityService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ProductCommentServiceImpl implements ProductCommentService{

    @Autowired
    private ProductCommentEntityService productCommentEntityService;

    @Override
    public List<ProductComment> findAll() {
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
