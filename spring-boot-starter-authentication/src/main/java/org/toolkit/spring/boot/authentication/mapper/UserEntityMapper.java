package org.toolkit.spring.boot.authentication.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.toolkit.spring.boot.authentication.entities.UserEntity;
import org.toolkit.spring.boot.authentication.pojo.UserPojo;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserEntityMapper {

	UserPojo userEntityToUserPojo(UserEntity entity);

	@Mapping(target = "username", ignore = true)
	@Mapping(target = "sex", ignore = true)
	@Mapping(target = "password", ignore = true)
	@Mapping(target = "age", ignore = true)
	@Mapping(target = "phone", ignore = true)
	@Mapping(target = "id", ignore = true)
	@Mapping(target = "avatar", ignore = true)
	UserEntity userPojoToUserEntity(UserPojo pojo);
}
