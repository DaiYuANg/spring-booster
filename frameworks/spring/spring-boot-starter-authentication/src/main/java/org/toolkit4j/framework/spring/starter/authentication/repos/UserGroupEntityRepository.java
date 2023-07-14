package org.toolkit4j.framework.spring.starter.authentication.repos;

import java.math.BigInteger;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.toolkit4j.framework.spring.starter.authentication.entities.UserGroupEntity;

public interface UserGroupEntityRepository<T extends UserGroupEntity>
		extends JpaRepository<T, BigInteger>, JpaSpecificationExecutor<T> {
	List<Integer> findUsersByGroupId(Integer groupId);
}
