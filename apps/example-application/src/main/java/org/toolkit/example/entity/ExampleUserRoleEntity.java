package org.toolkit.example.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import org.toolkit.spring.boot.persistence.base.BaseEntity;

@Entity
@Table(name = "user_role")
public class ExampleUserRoleEntity extends BaseEntity {

    @Column
    private String roleCode;

    @Column
    private String roleName;
}
