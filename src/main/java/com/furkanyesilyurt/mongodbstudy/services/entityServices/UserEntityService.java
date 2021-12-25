package com.furkanyesilyurt.mongodbstudy.services.entityServices;

import com.furkanyesilyurt.mongodbstudy.dto.UserDetailDto;
import com.furkanyesilyurt.mongodbstudy.entities.User;
import com.furkanyesilyurt.mongodbstudy.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

import static com.furkanyesilyurt.mongodbstudy.converter.UserConverter.INSTANCE;

@Service
@Transactional
@RequiredArgsConstructor
// generates a constructor with 1 parameter for each field that requires special handling.
// All non-initialized final fields get a parameter, as well as any fields that are
// marked as @NonNull that aren't initialized where they are declared.
public class UserEntityService {

   //@Autowired
    private final UserRepository userRepository;

    public List<UserDetailDto> findAll(){
        return INSTANCE.convertUserListToUserDetailDtos(userRepository.findAll());
    }

    public User findById(String id){

        Optional<User> optional = userRepository.findById(id);

        User user = null;
        if (optional.isPresent()){
            user = optional.get();
        }

        return user;
    }

    public void deleteById(String id){
        userRepository.deleteById(id);
    }

    public User save(User user){
        return userRepository.save(user);
    }


}
