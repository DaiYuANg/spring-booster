package org.toolkit4J.standard.rbac;

import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import org.toolkit4j.standard.persistence.base.WithAutoIncrement;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Role extends WithAutoIncrement {

	private String roleName;

	private String roleCode;

	private String roleDesc;
}
