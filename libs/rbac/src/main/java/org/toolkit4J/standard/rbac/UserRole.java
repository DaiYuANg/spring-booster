package org.toolkit4J.standard.rbac;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import org.toolkit4j.standard.persistence.base.WithAutoIncrement;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class UserRole extends WithAutoIncrement {
	@Column
	private Integer userId;

	private Integer roleId;
}
