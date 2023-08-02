package org.toolkit.spring.boot.authentication.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.toolkit.spring.boot.authentication.entities.UserEntity;
import org.toolkit.spring.boot.authentication.pojo.UserPojo;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserEntityMapper {

	UserPojo userEntityToUserPojo(UserEntity entity);

	@Mapping(target = "versioning", ignore = true)
	@Mapping(target = "userRoleEntities", ignore = true)
	@Mapping(target = "updateBy", ignore = true)
	@Mapping(target = "updateAt", ignore = true)
	@Mapping(target = "sort", ignore = true)
	@Mapping(target = "remark", ignore = true)
	@Mapping(target = "orderedByTimeStamp", ignore = true)
	@Mapping(target = "createBy", ignore = true)
	@Mapping(target = "createAt", ignore = true)
	@Mapping(target = "username", ignore = true)
	@Mapping(target = "sex", ignore = true)
	@Mapping(target = "password", ignore = true)
	@Mapping(target = "age", ignore = true)
	@Mapping(target = "phone", ignore = true)
	@Mapping(target = "id", ignore = true)
	@Mapping(target = "avatar", ignore = true)
	UserEntity userPojoToUserEntity(UserPojo pojo);
}
