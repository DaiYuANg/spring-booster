package org.toolkit.spring.boot.authentication.repos;

import java.math.BigInteger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.toolkit.spring.boot.authentication.entities.GroupEntity;

public interface GroupEntityRepository<E extends GroupEntity>
		extends JpaRepository<E, BigInteger>, JpaSpecificationExecutor<E> {}
