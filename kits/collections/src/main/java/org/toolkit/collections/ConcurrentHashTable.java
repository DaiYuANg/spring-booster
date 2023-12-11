package org.toolkit.collections;

import com.google.errorprone.annotations.CompatibleWith;
import java.util.Collection;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;
import lombok.val;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.toolkit.collections.api.ConcurrentTable;

@ToString
@EqualsAndHashCode
public class ConcurrentHashTable<R, C, V> implements ConcurrentTable<R, C, V> {

	private final ConcurrentHashMap<R, ConcurrentMap<C, V>> internal = new ConcurrentHashMap<>();

	@Override
	public boolean contains(@NonNull @CompatibleWith("R") Object rowKey, @NotNull @NonNull Object columnKey) {
		@SuppressWarnings("unchecked")
		val rk = (R) rowKey;
		@SuppressWarnings("unchecked")
		val ck = (C) columnKey;
		return Optional.ofNullable(internal.get(rk))
				.map(column -> column.containsKey(ck))
				.orElse(false);
	}

	@Override
	public boolean containsRow(@NotNull @NonNull Object rowKey) {
		@SuppressWarnings("unchecked")
		val rk = (R) rowKey;
		return internal.containsKey(rk);
	}

	@Override
	public boolean containsColumn(@NotNull @NonNull Object columnKey) {
		return internal.keySet().stream().anyMatch(key -> key.equals(columnKey));
	}

	@Override
	public boolean containsValue(@NotNull @NonNull Object value) {
		@SuppressWarnings("unchecked")
		val v = (V) value;
		return internal.values().stream().anyMatch(column -> column.containsValue(v));
	}

	@Override
	public @Nullable V get(@NotNull @NonNull Object rowKey, @NotNull @NonNull Object columnKey) {
		@SuppressWarnings("unchecked")
		val rk = (R) rowKey;
		@SuppressWarnings("unchecked")
		val ck = (C) columnKey;
		return Optional.ofNullable(internal.get(rk))
				.map(column -> column.get(ck))
				.orElse(null);
	}

	@Override
	public boolean isEmpty() {
		return internal.isEmpty();
	}

	@Override
	public int size() {
		return internal.size();
	}

	@Override
	public void clear() {
		internal.clear();
	}

	@Override
	public V put(@NonNull @NotNull R rowKey, @NonNull @NotNull C columnKey, @NonNull @NotNull V value) {
		getColumnMap(rowKey).put(columnKey, value);
		return value;
	}

	@Override
	public void putAll(@NonNull @NotNull ConcurrentTable<? extends R, ? extends C, ? extends V> table) {}

	@Override
	@Nullable @javax.annotation.Nullable public V remove(@NonNull @NotNull Object rowKey, @NonNull @NotNull Object columnKey) {
		@SuppressWarnings("unchecked")
		val rk = (R) rowKey;
		@SuppressWarnings("unchecked")
		val ck = (C) columnKey;
		return Optional.ofNullable(getColumnMap(rk))
				.map(column -> {
					val value = column.get(ck);
					column.remove(ck, value);
					return value;
				})
				.orElse(null);
	}

	@Override
	public Map<C, V> row(@NonNull @NotNull R rowKey) {
		return internal.get(rowKey);
	}

	@Override
	public Map<R, V> column(@NonNull @NotNull C columnKey) {
		return internal.entrySet().stream()
				.filter(entry -> entry.getValue().containsKey(columnKey))
				.collect(Collectors.toMap(
						Map.Entry::getKey, entry -> entry.getValue().get(columnKey)));
	}

	@Override
	public @NonNull @NotNull Set<R> rowKeySet() {
		return internal.keySet();
	}

	@Override
	public @NonNull @NotNull Set<C> columnKeySet() {
		return internal.values().stream().map(Map::keySet).flatMap(Set::stream).collect(Collectors.toSet());
	}

	@Override
	public @NonNull @NotNull Collection<V> values() {
		return internal.values().stream()
				.flatMap(column -> column.values().stream())
				.collect(Collectors.toSet());
	}

	@Override
	public @NonNull @NotNull Map<R, Map<C, V>> rowMap() {
		return internal.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
	}

	private ConcurrentMap<C, V> getColumnMap(R rowKey) {
		return internal.computeIfAbsent(rowKey, k -> new ConcurrentHashMap<>());
	}
}
