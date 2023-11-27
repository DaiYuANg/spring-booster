package org.toolkit.spring.boot.mapping.core.structure;

import java.util.Set;

public interface Mapping<T> {
	String getNaming();

	String getCode();

	String getDescription();

	boolean getDelete();

	String getType();

	Set<MappingItem<T>> getItems();
}
