package org.toolkit4J.framework.spring.starter.authentication.services;

import java.math.BigInteger;
import java.util.List;
import org.toolkit4J.framework.spring.starter.authentication.entities.UserGroupEntity;

public interface IUserGroupService<Entity> {
	List<UserGroupEntity> findByGroupId(BigInteger groupId);
}
