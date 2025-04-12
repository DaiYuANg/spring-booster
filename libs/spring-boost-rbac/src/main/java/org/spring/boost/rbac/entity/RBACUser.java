package org.spring.boost.rbac.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.spring.boost.persistence.base.BaseEntity;

@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@ToString(callSuper = true)
public abstract class RBACUser extends BaseEntity {
  private String username;

  private String password;

}
