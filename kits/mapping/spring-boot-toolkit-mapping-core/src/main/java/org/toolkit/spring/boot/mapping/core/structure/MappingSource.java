package org.toolkit.spring.boot.mapping.core.structure;

import java.util.List;

public interface MappingSource {

	String getMappingKey();

	List<MappingItem<?>> getMappingItems();
}
