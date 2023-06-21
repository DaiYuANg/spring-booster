package org.kop.framework.spring.starter.authentication.services.impl;

import org.kop.framework.spring.starter.authentication.entities.UserEntity;
import org.kop.framework.spring.starter.authentication.repos.UserEntityRepository;
import org.kop.framework.spring.starter.authentication.services.IUserServices;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserServicesImpl implements IUserServices {
    private final UserEntityRepository userEntityRepository;

    public UserServicesImpl(UserEntityRepository userEntityRepository) {
        this.userEntityRepository = userEntityRepository;
    }

    @Override
    public Page<UserEntity> queryListUser(UserEntity userEntity, Pageable pageable) {
        return userEntityRepository.findAll(Example.of(userEntity), pageable);
    }
}
