package org.toolkit4J.framework.spring.starter.authentication.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.toolkit4J.framework.spring.starter.authentication.entities.UserEntity;

@Repository
public interface UserEntityRepository<T extends UserEntity> extends JpaRepository<T, Integer> {

}
