/* (C)2023*/
package org.spring.boost.mapping.database.source.service;

import java.util.Optional;
import org.spring.boost.mapping.database.source.entity.MappingEntity;

public interface MappingService {
    Optional<MappingEntity> search(String naming);
}
