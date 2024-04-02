package org.spring.boost.example.entity;

import lombok.Getter;
import lombok.Setter;
import org.spring.boost.example.base.BaseEntity;

import java.util.Collection;

@Getter
@Setter
public class SysUser extends BaseEntity{
  private String username;

  private short gender;

  private String password;
}
