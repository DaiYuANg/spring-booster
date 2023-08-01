package org.toolkit.spring.boot.authentication.entities;

import jakarta.persistence.*;
import org.toolkit.spring.boot.persistence.base.SuperId;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "sys_user_role")
public class UserRoleEntity extends SuperId {
	@Column
	private Integer userId;

	private Integer roleId;
}
