package org.toolkit.spring.boot.mapping.base.structure;

import java.util.Set;

public interface Mapping<T, I extends MappingItem<T>> {
	String getNaming();

	String getCode();

	String getDescription();

	Boolean getEnable();

	String getType();

	Set<I> getItems();
}
