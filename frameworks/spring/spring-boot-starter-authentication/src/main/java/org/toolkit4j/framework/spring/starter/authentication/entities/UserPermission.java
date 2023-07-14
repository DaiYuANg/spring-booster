package org.toolkit4j.framework.spring.starter.authentication.entities;

import jakarta.persistence.Entity;
import org.toolkit4j.standard.persistence.base.WithAutoIncrement;

@Entity
public class UserPermission extends WithAutoIncrement {
	private Integer pid;

	private String permission;

	private String permissionName;

	private String desc;

	private String path;
}
