package org.toolkit.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.toolkit.example.entity.ExampleUserGroupEntity;

public interface ExampleUserGroupEntityRepository extends JpaRepository<ExampleUserGroupEntity, String> {}
