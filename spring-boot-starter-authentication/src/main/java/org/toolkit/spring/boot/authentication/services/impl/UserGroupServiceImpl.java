package org.toolkit.spring.boot.authentication.services.impl;

import jakarta.annotation.Resource;
import java.math.BigInteger;
import java.util.List;
import org.springframework.stereotype.Service;
import org.toolkit.spring.boot.authentication.entities.UserGroupEntity;
import org.toolkit.spring.boot.authentication.repos.UserGroupEntityRepository;
import org.toolkit.spring.boot.authentication.services.IUserGroupService;

@Service
public class UserGroupServiceImpl implements IUserGroupService<UserGroupEntity> {

	@Resource
	private UserGroupEntityRepository<UserGroupEntity> userGroupEntityRepository;

	@Override
	public List<UserGroupEntity> findByGroupId(BigInteger groupId) {
		return userGroupEntityRepository.findUsersByGroupId(groupId);
	}
}
