package org.toolkit.collections.api;

import com.google.errorprone.annotations.CompatibleWith;
import java.util.Collection;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import javax.annotation.Nonnull;
import lombok.NonNull;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface ConcurrentTable<R, C, V> {

	boolean contains(
			@NonNull @CompatibleWith("R") Object rowKey, @NonNull @Nonnull @CompatibleWith("C") Object columnKey);

	boolean containsRow(@Nonnull @NonNull @CompatibleWith("R") Object rowKey);

	boolean containsColumn(@Nonnull @NonNull @CompatibleWith("C") Object columnKey);

	boolean containsValue(@Nonnull @NonNull @CompatibleWith("V") Object value);

	//
	@Nullable @javax.annotation.Nullable V get(
			@Nonnull @NonNull @CompatibleWith("R") Object rowKey,
			@Nonnull @NonNull @CompatibleWith("C") Object columnKey);

	@Nullable @javax.annotation.Nullable default Optional<V> getOptional(
			@Nonnull @NonNull @CompatibleWith("R") Object rowKey,
			@Nonnull @NonNull @CompatibleWith("C") Object columnKey) {
		return Optional.ofNullable(get(rowKey, columnKey));
	}

	boolean isEmpty();

	int size();

	void clear();

	V put(
			@Nonnull @NonNull @NotNull R rowKey,
			@Nonnull @NonNull @NotNull C columnKey,
			@Nonnull @NonNull @NotNull V value);

	void putAll(@Nonnull @NonNull @NotNull ConcurrentTable<? extends R, ? extends C, ? extends V> table);

	@Nullable @javax.annotation.Nullable V remove(
			@Nonnull @NonNull @NotNull @CompatibleWith("R") Object rowKey,
			@Nonnull @NonNull @NotNull @CompatibleWith("C") Object columnKey);

	default Optional<V> removeOptional(
			@Nonnull @NonNull @NotNull @CompatibleWith("R") Object rowKey,
			@Nonnull @NonNull @NotNull @CompatibleWith("C") Object columnKey) {
		return Optional.ofNullable(remove(rowKey, columnKey));
	}

	Map<C, V> row(@Nonnull @NonNull @NotNull R rowKey);

	Map<R, V> column(@Nonnull @NonNull @NotNull C columnKey);

	//
	//    @Nonnull
	//    @NonNull @NotNull
	//    Set<ConcurrentTable.Cell<R, C, V>> cellSet();

	@Nonnull
	@NonNull @NotNull Set<R> rowKeySet();

	@Nonnull
	@NonNull @NotNull Set<C> columnKeySet();

	@Nonnull
	@NonNull @NotNull Collection<V> values();

	@Nonnull
	@NonNull @NotNull Map<R, Map<C, V>> rowMap();

	//    @Nonnull
	//    @NonNull @NotNull
	//    Map<C, Map<R, V>> columnMap();

}
