package com.furkanyesilyurt.mongodbstudy.repository;

import com.furkanyesilyurt.mongodbstudy.entities.ProductComment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductCommentRepository extends MongoRepository<ProductComment, String> {
}
