package org.spring.boost.example.entity;

import lombok.Getter;
import lombok.Setter;
import org.spring.boost.example.base.BaseEntity;

@Getter
@Setter
public class SysPermission extends BaseEntity {
  private String permissionName;

  private String identifier;
}
