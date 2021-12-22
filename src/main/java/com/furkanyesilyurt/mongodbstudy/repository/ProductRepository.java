package com.furkanyesilyurt.mongodbstudy.repository;

import com.furkanyesilyurt.mongodbstudy.dto.ProductDetailDto;
import com.furkanyesilyurt.mongodbstudy.entities.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {

    List<Product> findAllByCategoryId(String categoryId);
    ProductDetailDto findProductDetailDtoById(String id);
}
