package com.furkanyesilyurt.mongodbstudy.services;

import com.furkanyesilyurt.mongodbstudy.dto.UserDetailDto;
import com.furkanyesilyurt.mongodbstudy.entities.User;

import java.util.List;

public interface UserService {

    List<UserDetailDto> findAll();

    User findById(String id) ;

    User save(User user);

    void delete(String id) ;



}
