package org.toolkit.example.backend.minimal.example;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExampleEntityRepository extends CrudRepository<ExampleEntity, String> {}
