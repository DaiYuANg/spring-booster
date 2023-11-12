package org.toolkit.spring.boot.minio.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.toolkit.spring.boot.minio.persistence.entity.MinioObjectAccessEntity;

@Repository
@RepositoryRestResource(collectionResourceRel = "minio", path = "minio")
public interface MinioResourceAccessRecordRepository extends JpaRepository<MinioObjectAccessEntity, String> {}
