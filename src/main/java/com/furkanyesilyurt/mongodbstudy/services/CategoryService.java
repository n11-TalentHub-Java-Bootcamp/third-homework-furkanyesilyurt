package com.furkanyesilyurt.mongodbstudy.services;

import com.furkanyesilyurt.mongodbstudy.entities.Category;

import java.util.List;

public interface CategoryService {

    List<Category> findAll();

    Category findById(String id) ;

    Category save(Category category);

    void delete(String id) ;

}
