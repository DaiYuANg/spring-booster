package org.toolkit.spring.boot.starter.minio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.toolkit.spring.boot.starter.minio.entities.MinioResourceAccessEntity;
import org.toolkit.spring.boot.starter.minio.entities.MinioResourceEntity;

@Repository
public interface MinioResourceAccessEntityRepository extends CrudRepository<MinioResourceAccessEntity, String>, JpaSpecificationExecutor<MinioResourceAccessEntity> {}
