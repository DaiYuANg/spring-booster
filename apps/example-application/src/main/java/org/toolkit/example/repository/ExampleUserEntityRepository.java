package org.toolkit.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;
import org.toolkit.example.eneity.ExampleUserEntity;

import java.util.Optional;

@Repository
public interface ExampleUserEntityRepository extends JpaRepository<ExampleUserEntity, String> {
    @NonNull
    Optional<ExampleUserEntity> findByUsername(@NonNull Object unknownAttr1);
}
