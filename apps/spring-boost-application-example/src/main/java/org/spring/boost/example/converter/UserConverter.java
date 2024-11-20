package org.spring.boost.example.converter;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.spring.boost.example.entity.ExampleUser;
import org.spring.boost.example.model.UserForm;
import org.spring.boost.example.service.ExampleUserService;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserConverter {

  @Mapping(target = "version", ignore = true)
  @Mapping(target = "updateBy", ignore = true)
  @Mapping(target = "updateAt", ignore = true)
  @Mapping(target = "sort", ignore = true)
  @Mapping(target = "id", ignore = true)
  @Mapping(target = "ext", ignore = true)
  @Mapping(target = "email", ignore = true)
  @Mapping(target = "createBy", ignore = true)
  @Mapping(target = "createAt", ignore = true)
  ExampleUser form2entity(UserForm userForm);
}
