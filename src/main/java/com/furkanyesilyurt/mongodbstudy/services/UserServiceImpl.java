package com.furkanyesilyurt.mongodbstudy.services;

import com.furkanyesilyurt.mongodbstudy.converter.UserConverter;
import com.furkanyesilyurt.mongodbstudy.dto.UserDetailDto;
import com.furkanyesilyurt.mongodbstudy.entities.User;
import com.furkanyesilyurt.mongodbstudy.services.entityServices.UserEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.furkanyesilyurt.mongodbstudy.converter.UserConverter.INSTANCE;

@Service
@RequiredArgsConstructor
// generates a constructor with 1 parameter for each field that requires special handling.
// All non-initialized final fields get a parameter, as well as any fields that are
// marked as @NonNull that aren't initialized where they are declared.
public class UserServiceImpl implements UserService{

    //@Autowired
    private final UserEntityService userEntityService;

    @Override
    public List<UserDetailDto> findAll() {
        return userEntityService.findAll();
    }

    @Override
    public User findById(String id) {
        return userEntityService.findById(id);
    }

    @Override
    public User save(User user) {
        return userEntityService.save(user);
    }

    @Override
    public void delete(String id) {
        userEntityService.deleteById(id);
    }


}
