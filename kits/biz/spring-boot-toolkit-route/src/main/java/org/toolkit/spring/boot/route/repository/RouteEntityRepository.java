package org.toolkit.spring.boot.route.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.toolkit.spring.boot.route.entity.RouteEntity;

public interface RouteEntityRepository
		extends JpaRepository<RouteEntity, String>, JpaSpecificationExecutor<RouteEntity> {}
