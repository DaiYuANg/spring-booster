package org.spring.boost.example.entity;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import org.spring.boost.rbac.entity.RBACUser;
//import org.spring.boost.rbac.entity.SysUser;

@Getter
@Setter
@Entity
public class ExampleUser extends RBACUser {
  private String email;
}
