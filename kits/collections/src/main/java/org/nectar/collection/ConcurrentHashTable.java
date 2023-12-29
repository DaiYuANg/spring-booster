/* (C)2023*/
package org.nectar.collection;

import com.google.common.collect.Table;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;
import lombok.NonNull;
import lombok.ToString;
import lombok.val;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.nectar.collection.api.ConcurrentTable;

@ToString
@SuppressWarnings("unchecked")
public class ConcurrentHashTable<R, C, V> implements ConcurrentTable<R, C, V> {

	private final transient ConcurrentMap<R, ConcurrentMap<C, V>> internal = new ConcurrentHashMap<>();

	@Override
	public boolean contains(@NonNull Object rowKey, @NonNull Object columnKey) {
		return Optional.ofNullable(internal.get((R) rowKey))
				.map(rowMap -> rowMap.containsKey((C) columnKey))
				.orElse(false);
	}

	@Override
	public boolean containsRow(@NonNull Object rowKey) {
		return internal.containsKey((R) rowKey);
	}

	@Override
	public boolean containsColumn(@NonNull Object columnKey) {
		return internal.values().stream().anyMatch(rowMap -> rowMap.containsKey((C) columnKey));
	}

	@Override
	public boolean containsValue(@NonNull Object value) {
		return internal.values().stream().anyMatch(rowMap -> rowMap.containsValue((V) value));
	}

	@Override
	@Nullable public V get(@NonNull Object rowKey, @NonNull Object columnKey) {
		return Optional.ofNullable(internal.get((R) rowKey))
				.map(row -> row.get((C) columnKey))
				.orElse(null);
	}

	@Override
	public boolean isEmpty() {
		return internal.isEmpty();
	}

	@Override
	public int size() {
		return internal.values().stream().mapToInt(Map::size).sum();
	}

	@Override
	public void clear() {
		internal.clear();
	}

	@Override
	public V put(R rowKey, C columnKey, V value) {
		internal.compute(rowKey, (k, existingMap) -> {
			if (existingMap == null) {
				existingMap = new ConcurrentHashMap<>();
				existingMap.put(columnKey, value);
			} else {
				existingMap.put(columnKey, value);
			}
			return existingMap;
		});
		return value;
	}

	@Override
	public void putAll(@NotNull Table<? extends R, ? extends C, ? extends V> table) {
		table.cellSet().forEach(cell -> put(cell.getRowKey(), cell.getColumnKey(), cell.getValue()));
	}

	@Override
	@Nullable public V remove(@NonNull Object rowKey, @NonNull Object columnKey) {
		return Optional.ofNullable(internal.get((R) rowKey))
				.map(row -> row.remove((C) columnKey))
				.orElse(null);
	}

	@Override
	public Map<C, V> row(@NonNull R rowKey) {
		return internal.computeIfAbsent(rowKey, k -> new ConcurrentHashMap<>());
	}

	@Override
	public Map<R, V> column(C columnKey) {
		return internal.entrySet().stream()
				.filter(entry -> entry.getValue().containsKey(columnKey))
				.collect(Collectors.toMap(
						Map.Entry::getKey, entry -> entry.getValue().get(columnKey)));
	}

	@Override
	public Set<Table.Cell<R, C, V>> cellSet() {
		return internal.entrySet().stream()
				.flatMap(entry -> entry.getValue().entrySet().stream()
						.map(cellEntry ->
								new ImmutableCell<>(entry.getKey(), cellEntry.getKey(), cellEntry.getValue())))
				.collect(Collectors.toSet());
	}

	@Override
	public Set<R> rowKeySet() {
		return internal.keySet();
	}

	@Override
	public Set<C> columnKeySet() {
		return internal.values().stream()
				.flatMap(rowMap -> rowMap.keySet().stream())
				.collect(Collectors.toSet());
	}

	@Override
	public Collection<V> values() {
		return internal.values().stream()
				.map(Map::values)
				.flatMap(Collection::stream)
				.collect(Collectors.toList());
	}

	@Override
	public Map<R, Map<C, V>> rowMap() {
		return internal.entrySet().stream()
				.collect(Collectors.toMap(Map.Entry::getKey, entry -> new HashMap<>(entry.getValue())));
	}

	@Override
	public Map<C, Map<R, V>> columnMap() {
		val result = new ConcurrentHashMap<C, Map<R, V>>();
		internal.values().stream().flatMap(rowMap -> rowMap.entrySet().stream()).forEach(cellEntry -> {
			val columnKey = cellEntry.getKey();
			result.computeIfAbsent(columnKey, k -> new ConcurrentHashMap<>())
					.put(getRowKeyByColumnKey(columnKey), cellEntry.getValue());
		});

		return result;
	}

	private @Nullable R getRowKeyByColumnKey(C columnKey) {
		return internal.entrySet().stream()
				.filter(entry -> entry.getValue().containsKey(columnKey))
				.map(Map.Entry::getKey)
				.findFirst()
				.orElse(null);
	}
}
