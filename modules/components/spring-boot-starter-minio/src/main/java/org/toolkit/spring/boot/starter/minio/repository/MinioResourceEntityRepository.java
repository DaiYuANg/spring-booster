package org.toolkit.spring.boot.starter.minio.repository;

import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;
import org.toolkit.spring.boot.starter.minio.entity.MinioResourceEntity;

import java.util.Optional;

@Repository
public interface MinioResourceEntityRepository extends JpaRepository<MinioResourceEntity, String> {
    Optional<MinioResourceEntity> findByMd5(@NonNull String md5);

//    @Override
//    @NotNull
//    Optional<MinioResourceEntity> findById(@NotNull String s);
}