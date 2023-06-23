package org.kop.framework.spring.starter.authentication.services;

import org.kop.framework.spring.starter.authentication.entities.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IUserServices<T extends UserEntity> {
    Page<T> queryListUser(T userEntity, Pageable pageable);
}
