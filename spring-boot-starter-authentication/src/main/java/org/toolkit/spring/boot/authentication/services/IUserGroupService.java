package org.toolkit.spring.boot.authentication.services;

import java.math.BigInteger;
import java.util.List;
import org.toolkit.spring.boot.authentication.entities.UserGroupEntity;

public interface IUserGroupService<Entity> {
	List<UserGroupEntity> findByGroupId(BigInteger groupId);
}
