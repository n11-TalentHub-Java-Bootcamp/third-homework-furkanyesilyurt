package com.furkanyesilyurt.mongodbstudy.services;

import com.furkanyesilyurt.mongodbstudy.dto.ProductDetailDto;
import com.furkanyesilyurt.mongodbstudy.entities.Product;

import java.util.List;

public interface ProductService {

    List<Product> findAll();

    Product findById(String id);

    ProductDetailDto findProductDetailDtoById(String id);

    Product save(Product product);

    void deleteById(String id);

    List<ProductDetailDto> findAllProductByCategoryId(String categoryId);

}
