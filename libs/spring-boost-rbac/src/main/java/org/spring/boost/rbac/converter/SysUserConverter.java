package org.spring.boost.rbac.converter;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.spring.boost.rbac.entity.RBACUser;
import org.spring.boost.rbac.model.SpringBoostUserDetail;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface SysUserConverter {

  @Mapping(target = "authorities", ignore = true)
  SpringBoostUserDetail sysUserToSysUserDetail(RBACUser RBACUser);
}
