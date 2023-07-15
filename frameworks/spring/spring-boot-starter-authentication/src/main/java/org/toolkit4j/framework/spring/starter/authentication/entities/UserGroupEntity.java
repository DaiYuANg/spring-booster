package org.toolkit4J.framework.spring.starter.authentication.entities;

import jakarta.persistence.Entity;
import org.toolkit4j.standard.persistence.base.WithAutoIncrement;

@Entity
public class UserGroupEntity extends WithAutoIncrement {
	private Integer userId;

	private Integer groupId;
}
