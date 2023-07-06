package org.kop.framework.spring.starter.authentication.repos;

import org.kop.framework.spring.starter.authentication.entities.UserGroupEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.math.BigInteger;
import java.util.List;

public interface UserGroupEntityRepository<T extends UserGroupEntity> extends JpaRepository<T, BigInteger>, JpaSpecificationExecutor<T> {
    List<Integer> findUsersByGroupId(Integer groupId);
}