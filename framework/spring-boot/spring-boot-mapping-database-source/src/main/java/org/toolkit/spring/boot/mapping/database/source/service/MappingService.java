/* (C)2023*/
package org.toolkit.spring.boot.mapping.database.source.service;

import java.util.Optional;
import org.toolkit.spring.boot.mapping.database.source.entity.MappingEntity;

public interface MappingService {
	Optional<MappingEntity> search(String naming);
}
