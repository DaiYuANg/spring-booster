package org.toolkit.spring.boot.starter.minio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.toolkit.spring.boot.starter.minio.entity.MinioResourceAccessRecord;

@Repository
public interface MinioResourceAccessRecordRepository extends JpaRepository<MinioResourceAccessRecord, String> {
}