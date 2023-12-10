package org.toolkit.example.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import java.io.Serial;
import org.toolkit.spring.boot.persistence.base.BaseEntity;

@Entity
@Table(name = "user_role")
public class ExampleUserRoleEntity extends BaseEntity {

	@Serial
	private static final long serialVersionUID = 1L;

	@Column
	private String roleCode;

	@Column
	private String roleName;
}
