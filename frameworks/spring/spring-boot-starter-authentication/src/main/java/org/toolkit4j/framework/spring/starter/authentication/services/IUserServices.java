package org.toolkit4j.framework.spring.starter.authentication.services;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.toolkit4j.framework.spring.starter.authentication.entities.UserEntity;

public interface IUserServices<E extends UserEntity> {
	Page<E> queryPageableList(E entity, Pageable pageable);

	List<UserEntity> queryListByGroup(Integer groupId);
}
