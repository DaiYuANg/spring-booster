package org.toolkit4j.framework.spring.starter.authentication.services.impl;

import jakarta.annotation.Resource;
import lombok.val;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.toolkit4j.framework.spring.starter.authentication.entities.UserEntity;
import org.toolkit4j.framework.spring.starter.authentication.entities.UserGroupEntity;
import org.toolkit4j.framework.spring.starter.authentication.repos.UserEntityRepository;
import org.toolkit4j.framework.spring.starter.authentication.repos.UserGroupEntityRepository;
import org.toolkit4j.framework.spring.starter.authentication.services.IUserServices;

import java.util.List;

@Service
public class UserServicesImpl implements IUserServices<UserEntity> {

    @Resource
    private UserEntityRepository<UserEntity> userEntityRepository;

    @Resource
    private UserGroupEntityRepository<UserGroupEntity> userGroupEntityRepository;

    @Override
    public Page<UserEntity> queryPageableList(UserEntity entity, Pageable pageable) {
        return userEntityRepository.findAll(Example.of(entity), pageable);
    }

    @Override
    public List<UserEntity> queryListByGroup(Integer groupId) {
        val usersId = userGroupEntityRepository.findUsersByGroupId(groupId);
        return userEntityRepository.findAllById(usersId);
    }
}