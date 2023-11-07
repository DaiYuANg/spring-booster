package org.toolkit.spring.boot.starter.minio.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.toolkit.spring.boot.starter.minio.persistence.entity.MinioObjectAccessEntity;

@Repository
public interface MinioResourceAccessRecordRepository extends JpaRepository<MinioObjectAccessEntity, String> {
}