package org.kop.framework.spring.starter.authentication.services;

import org.kop.framework.spring.starter.authentication.entities.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IUserServices<E extends UserEntity> {
    Page<E> queryPageableList(E entity, Pageable pageable);

    List<UserEntity> queryListByGroup(Integer groupId);
}
