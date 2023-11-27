package org.toolkit.spring.boot.mapping.core.structure;

import java.util.List;

public interface MappingSource<T, I extends MappingItem<T>> {

	Mapping<T> mapping();

	List<I> mappingItems();
}
