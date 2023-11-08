package org.toolkit.spring.boot.starter.minio.persistence.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.toolkit.spring.boot.starter.minio.persistence.entity.MinioObjectEntity;

@Repository
public interface MinioResourceEntityRepository extends JpaRepository<MinioObjectEntity, String> {
	//    Optional<MinioResourceEntity> findByMd5(@NonNull String md5);

	//    @Override
	//    @NotNull
	//    Optional<MinioResourceEntity> findById(@NotNull String s);
	@Query("SELECT e.path FROM MinioObjectEntity e WHERE e.md5 = :md5")
	Optional<String> findPathMd5(@Param("md5") String md5);
}
