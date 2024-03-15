package org.spring.boost.example.entity;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import org.spring.boost.example.base.BaseEntity;

@Entity
@Getter
@Setter
public class SysUser extends BaseEntity {
  private String username;

  private short gender;
}
