package org.kop.framework.spring.starter.authentication.repos;

import org.kop.framework.spring.starter.authentication.entities.UserGroupEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.math.BigInteger;
import java.util.List;

public interface UserGroupEntityRepository extends JpaRepository<UserGroupEntity, BigInteger>, JpaSpecificationExecutor<UserGroupEntity> {
    List<Integer> findUsersByGroupId(Integer groupId);
}