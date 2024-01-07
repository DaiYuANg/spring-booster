/* (C)2023*/
package org.toolkit.spring.boot.mapping.core.structure;

import org.jetbrains.annotations.NotNull;

public interface MappingItem<T> {

    @NotNull T getValue();

    @NotNull String getText();

    int getSort();
}
