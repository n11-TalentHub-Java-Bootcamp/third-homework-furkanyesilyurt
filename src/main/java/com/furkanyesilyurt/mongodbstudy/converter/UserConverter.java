package com.furkanyesilyurt.mongodbstudy.converter;

import com.furkanyesilyurt.mongodbstudy.dto.UserDetailDto;
import com.furkanyesilyurt.mongodbstudy.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserConverter {

    UserConverter INSTANCE = Mappers.getMapper(UserConverter.class);

    List<UserDetailDto> convertUserListToUserDetailDtos (List<User> userList);

}
