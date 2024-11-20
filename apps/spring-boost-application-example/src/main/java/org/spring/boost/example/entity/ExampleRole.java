package org.spring.boost.example.entity;

import jakarta.persistence.Entity;
import org.spring.boost.rbac.entity.SysRole;

@Entity
public class ExampleRole extends SysRole<ExamplePermissionGroup> {
}
