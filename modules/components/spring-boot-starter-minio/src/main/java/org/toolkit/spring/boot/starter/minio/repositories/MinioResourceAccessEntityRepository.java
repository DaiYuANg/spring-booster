package org.toolkit.spring.boot.starter.minio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.toolkit.spring.boot.starter.minio.entities.MinioResourceAccessEntity;

@Repository
public interface MinioResourceAccessEntityRepository extends JpaRepository<MinioResourceAccessEntity, String> {}
