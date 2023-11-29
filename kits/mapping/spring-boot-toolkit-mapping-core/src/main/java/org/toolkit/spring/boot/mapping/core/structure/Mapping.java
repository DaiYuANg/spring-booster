package org.toolkit.spring.boot.mapping.core.structure;

import java.util.Set;

public interface Mapping<T, I extends MappingItem<T>> {
    String getNaming();

    String getCode();

    String getDescription();

    Boolean getDelete();

    String getType();

    Set<I> getItems();
}
