package com.furkanyesilyurt.mongodbstudy.repository;

import com.furkanyesilyurt.mongodbstudy.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
}
