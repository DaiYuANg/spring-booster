package org.toolkit4J.framework.spring.starter.authentication.repos;

import java.math.BigInteger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.toolkit4J.framework.spring.starter.authentication.entities.GroupEntity;

public interface GroupEntityRepository<E extends GroupEntity>
		extends JpaRepository<E, BigInteger>, JpaSpecificationExecutor<E> {}
