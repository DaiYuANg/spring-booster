package org.kop.framework.spring.starter.authentication.entities;

import jakarta.persistence.Entity;
import org.kop.standard.persistence.base.WithAutoIncrement;

@Entity
public class UserPermission extends WithAutoIncrement {
    private Integer pid;

    private String permission;

    private String permissionName;

    private String desc;

    private String path;
}