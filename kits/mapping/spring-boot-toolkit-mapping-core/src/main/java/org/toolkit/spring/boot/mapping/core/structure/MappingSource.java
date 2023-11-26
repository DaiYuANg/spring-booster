package org.toolkit.spring.boot.mapping.core.structure;

import java.util.List;

public interface MappingSource<T> {

    Mapping<T> mapping();

    List<MappingItem<T>> mappingItems();
}
