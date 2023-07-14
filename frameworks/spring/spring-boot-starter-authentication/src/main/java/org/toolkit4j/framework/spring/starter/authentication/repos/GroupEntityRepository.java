package org.toolkit4j.framework.spring.starter.authentication.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.toolkit4j.framework.spring.starter.authentication.entities.GroupEntity;

import java.math.BigInteger;

public interface GroupEntityRepository<E extends GroupEntity> extends JpaRepository<E, BigInteger>, JpaSpecificationExecutor<E> {
}