/* (C)2023*/
package org.toolkit.spring.boot.route.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.toolkit.spring.boot.route.entity.RouteEntity;

@Repository
@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "route", path = "route")
public interface RouteEntityRepository
		extends JpaRepository<RouteEntity, String>, JpaSpecificationExecutor<RouteEntity> {}
