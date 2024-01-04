/* (C)2023*/
package org.toolkit.spring.boot.mapping.base.structure;

import java.util.List;

public interface MappingSource<T, I extends MappingItem<T>> {

    Mapping<T, I> mapping();

    List<I> mappingItems();
}
