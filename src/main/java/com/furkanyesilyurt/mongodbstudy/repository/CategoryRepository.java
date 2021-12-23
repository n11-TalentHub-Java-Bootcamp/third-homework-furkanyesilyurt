package com.furkanyesilyurt.mongodbstudy.repository;

import com.furkanyesilyurt.mongodbstudy.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends MongoRepository<Category, String> {
}
