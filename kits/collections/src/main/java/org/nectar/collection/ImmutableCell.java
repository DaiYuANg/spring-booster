/* (C)2023*/
package org.nectar.collection;

import com.google.common.collect.Table;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@RequiredArgsConstructor
@ToString
public class ImmutableCell<R, C, V> implements Table.Cell<R, C, V> {
	private final R rowKey;
	private final C columnKey;
	private final V value;
}
