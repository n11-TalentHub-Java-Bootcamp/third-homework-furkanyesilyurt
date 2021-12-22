package com.furkanyesilyurt.mongodbstudy.services;

import com.furkanyesilyurt.mongodbstudy.entities.Category;
import com.furkanyesilyurt.mongodbstudy.services.CategoryService;
import com.furkanyesilyurt.mongodbstudy.services.entityServices.CategoryEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryEntityService categoryEntityService;

    public List<Category> findAll() {
        return categoryEntityService.findAll();
    }

    public Category findById(String id) {
        return categoryEntityService.findById(id);
    }

    public Category save(Category category) {
        return categoryEntityService.save(category);
    }

    public void delete(String id) {
        categoryEntityService.deleteById(id);
    }
}
