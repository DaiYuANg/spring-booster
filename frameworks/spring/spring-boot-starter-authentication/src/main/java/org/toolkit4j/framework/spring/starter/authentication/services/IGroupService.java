package org.toolkit4j.framework.spring.starter.authentication.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.toolkit4j.framework.spring.starter.authentication.entities.GroupEntity;

public interface IGroupService<E extends GroupEntity> {
    Page<E> queryPageableList(E entity, Pageable pageable);
}
