package org.toolkit4J.standard.rbac;

import jakarta.persistence.*;
import java.util.List;
import org.toolkit4j.standard.persistence.base.WithAutoIncrement;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "sys_user")
public class User extends WithAutoIncrement {
	@Column
	private String username;

	@Column
	private String password;

	@OneToMany
	List<UserRole> userRoles;
}
