package org.spring.boost.example.entity;

import io.swagger.v3.oas.models.examples.Example;
import jakarta.persistence.Entity;
import org.spring.boost.persistence.base.BaseEntity;
import org.spring.boost.rbac.entity.SysRole;

@Entity
public class ExampleRole extends SysRole<ExamplePermissionGroup> {
}
