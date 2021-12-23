package com.furkanyesilyurt.mongodbstudy.services;

import com.furkanyesilyurt.mongodbstudy.entities.Category;
import com.furkanyesilyurt.mongodbstudy.services.entityServices.CategoryEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
// generates a constructor with 1 parameter for each field that requires special handling.
// All non-initialized final fields get a parameter, as well as any fields that are
// marked as @NonNull that aren't initialized where they are declared.
public class CategoryServiceImpl implements CategoryService {

    //@Autowired
    private final CategoryEntityService categoryEntityService;

    @Override
    public List<Category> findAll() {
        return categoryEntityService.findAll();
    }

    @Override
    public Category findById(String id) {
        return categoryEntityService.findById(id);
    }

    @Override
    public Category save(Category category) {
        return categoryEntityService.save(category);
    }

    @Override
    public void delete(String id) {
        categoryEntityService.deleteById(id);
    }
}
