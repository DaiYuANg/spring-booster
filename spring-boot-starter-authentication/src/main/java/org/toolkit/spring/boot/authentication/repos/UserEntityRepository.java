package org.toolkit.spring.boot.authentication.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.toolkit.spring.boot.authentication.entities.UserEntity;

@Repository
public interface UserEntityRepository<T extends UserEntity> extends JpaRepository<T, Integer> {}
