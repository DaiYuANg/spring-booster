package org.toolkit4J.framework.spring.starter.authentication.services;

import org.toolkit4J.framework.spring.starter.authentication.entities.UserGroupEntity;

import java.math.BigInteger;
import java.util.List;

public interface IUserGroupService<Entity> {
    List<UserGroupEntity> findByGroupId(BigInteger groupId);
}
