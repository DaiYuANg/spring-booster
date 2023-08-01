package org.toolkit.spring.boot.authentication.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;
import org.toolkit.spring.boot.persistence.base.SuperId;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "sys_user_permission")
public class UserPermission extends SuperId {
	private Integer pid;

	private String permission;

	private String permissionName;

	private String desc;

	private String path;
}
