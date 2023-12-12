/* (C)2023*/
package org.toolkit.example.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;
import org.toolkit.example.entity.ExampleUserEntity;

@Repository
public interface ExampleUserEntityRepository extends JpaRepository<ExampleUserEntity, String> {
	@NonNull Optional<ExampleUserEntity> findByUsername(@NonNull String unknownAttr1);
}
