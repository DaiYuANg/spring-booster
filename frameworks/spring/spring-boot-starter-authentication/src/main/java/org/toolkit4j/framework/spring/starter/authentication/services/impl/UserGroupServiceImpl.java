package org.toolkit4J.framework.spring.starter.authentication.services.impl;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.toolkit4J.framework.spring.starter.authentication.entities.UserGroupEntity;
import org.toolkit4J.framework.spring.starter.authentication.repos.UserGroupEntityRepository;
import org.toolkit4J.framework.spring.starter.authentication.services.IUserGroupService;

import java.math.BigInteger;
import java.util.List;

@Service
public class UserGroupServiceImpl implements IUserGroupService<UserGroupEntity> {

    @Resource
    private UserGroupEntityRepository<UserGroupEntity> userGroupEntityRepository;

    @Override
    public List<UserGroupEntity> findByGroupId(BigInteger groupId){
        return userGroupEntityRepository.findUsersByGroupId(groupId);
    }
}
