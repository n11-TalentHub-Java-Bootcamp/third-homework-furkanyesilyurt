package com.furkanyesilyurt.mongodbstudy.controller;

import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.furkanyesilyurt.mongodbstudy.converter.UserConverter;
import com.furkanyesilyurt.mongodbstudy.dto.UserDetailDto;
import com.furkanyesilyurt.mongodbstudy.entities.User;
import com.furkanyesilyurt.mongodbstudy.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/users/")
@RequiredArgsConstructor
// generates a constructor with 1 parameter for each field that requires special handling.
// All non-initialized final fields get a parameter, as well as any fields that are
// marked as @NonNull that aren't initialized where they are declared.
public class UserController {

    //@Autowired
    private final UserService userService;

    //@GetMapping("")
//    @RequestMapping(value = "", method = RequestMethod.GET)
//    public MappingJacksonValue findAll() {
//        List<User> userList = userService.findAll();
//        List<UserDetailDto> userDtoList = UserConverter.INSTANCE.convertAllUsersToUserDTOs(userList);
//
//        String filterName = "UserDtoFilter";
//
//        SimpleFilterProvider simpleFilterProvider = getUserFilterProvider(filterName);
//
//        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(userDtoList);
//        mappingJacksonValue.setFilters(simpleFilterProvider);
//
//        return  mappingJacksonValue;
//    }

    @GetMapping("")
    public List<UserDetailDto> findAll(){
        return userService.findAll();
    }


    @GetMapping("/{id}")
    public User findById(@PathVariable String id) {
        return userService.findById(id);
    }

    @PostMapping("")
    public ResponseEntity<Object> save(@RequestBody User user) {

        user = userService.save(user);

        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        userService.delete(id);
    }

    private SimpleFilterProvider getUserFilterProvider(String filterName) {
        SimpleBeanPropertyFilter filter = getUserFilter();
        return new SimpleFilterProvider().addFilter(filterName, filter);
    }

    private SimpleBeanPropertyFilter getUserFilter() {
        return SimpleBeanPropertyFilter.filterOutAllExcept("id", "name", "lastName", "email","phoneNumber","userName");
    }
}
