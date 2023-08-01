package org.toolkit4j.framework.spring.boot.starter.dict.repos;

import java.math.BigInteger;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.toolkit4j.framework.spring.boot.starter.dict.entities.Dict;

@Repository
public interface DictRepository extends JpaRepository<Dict, BigInteger> {
	Optional<Dict> findByDictCodeIgnoreCase(String dictCode);
}
