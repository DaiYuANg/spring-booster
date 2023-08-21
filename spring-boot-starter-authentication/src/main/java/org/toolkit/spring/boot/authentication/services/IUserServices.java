package org.toolkit.spring.boot.authentication.services;

import java.math.BigInteger;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.toolkit.spring.boot.authentication.entities.UserEntity;

public interface IUserServices<E extends UserEntity> {
	Page<E> queryPageableList(E entity, Pageable pageable);

	List<UserEntity> queryListByGroup(BigInteger groupId);
}