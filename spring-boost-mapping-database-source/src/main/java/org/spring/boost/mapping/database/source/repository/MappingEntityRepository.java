/* (C)2023*/
package org.spring.boost.mapping.database.source.repository;

import java.util.Optional;
import org.spring.boost.mapping.database.source.entity.MappingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

@Repository
public interface MappingEntityRepository
        extends JpaRepository<MappingEntity, String>, JpaSpecificationExecutor<MappingEntity> {
    @Query("select m from MappingEntity m where m.naming = ?1")
    Optional<MappingEntity> findByNaming(@NonNull String naming);
}
