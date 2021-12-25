package com.furkanyesilyurt.mongodbstudy.controller;

import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.furkanyesilyurt.mongodbstudy.converter.UserConverter;
import com.furkanyesilyurt.mongodbstudy.dto.UserDetailDto;
import com.furkanyesilyurt.mongodbstudy.entities.User;
import com.furkanyesilyurt.mongodbstudy.exceptions.UserNotFoundException;
import com.furkanyesilyurt.mongodbstudy.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
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

    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public List<UserDetailDto> findAll(){
        return userService.findAll();
    }


    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public MappingJacksonValue  findById(@PathVariable String id) {

        User user = userService.findById(id);

        if(user == null){
            throw new UserNotFoundException("User not found. id = " + id);
        }

        WebMvcLinkBuilder linkToUser = WebMvcLinkBuilder.linkTo(
                WebMvcLinkBuilder.methodOn(this.getClass())
                        .findAll()
        );

        UserDetailDto userDetailDto = UserConverter.INSTANCE.convertUserToUserDetailDto(user);

        String filterName = "UserDtoFilter";

        SimpleFilterProvider filters = getUserFilterProvider(filterName);

        EntityModel entityModel = EntityModel.of(userDetailDto);

        entityModel.add(linkToUser.withRel("All-users"));

        MappingJacksonValue mapping = new MappingJacksonValue(entityModel);

        mapping.setFilters(filters);

        return mapping;
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Object> save(@Valid @RequestBody UserDetailDto userDetailDto) {

        User user = UserConverter.INSTANCE.convertUserDetailDtoToUser(userDetailDto);

        user = userService.save(user);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("{id}")
                .buildAndExpand(user.getId())
                .toUri();

        return ResponseEntity.created(uri).build();
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
