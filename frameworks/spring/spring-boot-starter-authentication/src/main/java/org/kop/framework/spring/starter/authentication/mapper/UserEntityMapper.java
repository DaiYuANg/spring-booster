package org.kop.framework.spring.starter.authentication.mapper;

import org.kop.framework.spring.starter.authentication.entities.UserEntity;
import org.kop.framework.spring.starter.authentication.pojo.UserPojo;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserEntityMapper {

    UserPojo userEntityToUserPojo(UserEntity entity);
}
