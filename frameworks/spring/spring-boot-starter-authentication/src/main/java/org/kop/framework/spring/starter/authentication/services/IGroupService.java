package org.kop.framework.spring.starter.authentication.services;

import org.kop.framework.spring.starter.authentication.entities.GroupEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IGroupService<E extends GroupEntity> {
    Page<E> queryPageableList(E entity, Pageable pageable);
}
