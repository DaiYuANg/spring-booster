package org.toolkit.spring.boot.mapping.core.base;

import java.util.Optional;

public interface MappingSource {

	Optional<Object> getLabel(String key, String value);
}
