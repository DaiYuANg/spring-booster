package org.spring.boost.mapping.database.repository;

import org.spring.boost.mapping.database.entity.DictEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DictRepository extends CrudRepository<DictEntity, Long> {}
