package org.toolkit.spring.boot.mapping.core.structure;

import org.jetbrains.annotations.NotNull;

public interface MappingItem<T> {

	@NotNull T value();

	@NotNull String text();
}
