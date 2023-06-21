package org.kop.framework.spring.starter.authentication.services;

import org.kop.framework.spring.starter.authentication.entities.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IUserServices {
    Page<UserEntity> queryListUser(UserEntity userEntity, Pageable pageable);
}
