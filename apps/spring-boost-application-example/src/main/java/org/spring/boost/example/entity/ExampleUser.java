package org.spring.boost.example.entity;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.spring.boost.rbac.entity.SysUser;

@Getter
@Setter
@Entity
public class ExampleUser extends SysUser {
  private String email;
}
