/* (C)2023*/
package org.nectar.collection.api;

import com.google.common.collect.Table;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.CompatibleWith;
import java.util.Collection;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public interface ConcurrentTable<R, C, V> {

	/**
	 * Returns {@code true} if the table contains a mapping with the specified row and column keys.
	 *
	 * @param rowKey    key of row to search for
	 * @param columnKey key of column to search for
	 */
	boolean contains(@CompatibleWith("R") Object rowKey, @CompatibleWith("C") Object columnKey);

	/**
	 * Returns {@code true} if the table contains a mapping with the specified row key.
	 *
	 * @param rowKey key of row to search for
	 */
	boolean containsRow(@CompatibleWith("R") Object rowKey);

	/**
	 * Returns {@code true} if the table contains a mapping with the specified column.
	 *
	 * @param columnKey key of column to search for
	 */
	boolean containsColumn(@CompatibleWith("C") Object columnKey);

	/**
	 * Returns {@code true} if the table contains a mapping with the specified value.
	 *
	 * @param value value to search for
	 */
	boolean containsValue(@CompatibleWith("V") Object value);

	/**
	 * Returns the value corresponding to the given row and column keys, or {@code null} if no such
	 * mapping exists.
	 *
	 * @param rowKey    key of row to search for
	 * @param columnKey key of column to search for
	 */
	V get(@CompatibleWith("R") Object rowKey, @CompatibleWith("C") Object columnKey);

	default Optional<V> getOptional(@CompatibleWith("R") Object rowKey, @CompatibleWith("C") Object columnKey) {
		return Optional.ofNullable(get(rowKey, columnKey));
	}

	/**
	 * Returns {@code true} if the table contains no mappings.
	 */
	boolean isEmpty();

	/**
	 * Returns the number of row key / column key / value mappings in the table.
	 */
	int size();

	/**
	 * Compares the specified object with this table for equality. Two tables are equal when their
	 * cell views, as returned by {@link #cellSet}, are equal.
	 */
	@Override
	boolean equals(Object obj);

	/**
	 * Returns the hash code for this table. The hash code of a table is defined as the hash code of
	 * its cell view, as returned by {@link #cellSet}.
	 */
	@Override
	int hashCode();

	// Mutators

	/**
	 * Removes all mappings from the table.
	 */
	void clear();

	/**
	 * Associates the specified value with the specified keys. If the table already contained a
	 * mapping for those keys, the old value is replaced with the specified value.
	 *
	 * @param rowKey    row key that the value should be associated with
	 * @param columnKey column key that the value should be associated with
	 * @param value     value to be associated with the specified keys
	 * @return the value previously associated with the keys, or {@code null} if no mapping existed
	 * for the keys
	 */
	@CanIgnoreReturnValue
	V put(R rowKey, C columnKey, V value);

	/**
	 * Copies all mappings from the specified table to this table. The effect is equivalent to calling
	 * {@link #put} with each row key / column key / value mapping in {@code table}.
	 *
	 * @param table the table to add to this table
	 */
	void putAll(Table<? extends R, ? extends C, ? extends V> table);

	/**
	 * Removes the mapping, if any, associated with the given keys.
	 *
	 * @param rowKey    row key of mapping to be removed
	 * @param columnKey column key of mapping to be removed
	 * @return the value previously associated with the keys, or {@code null} if no such value existed
	 */
	@CanIgnoreReturnValue
	V remove(@CompatibleWith("R") Object rowKey, @CompatibleWith("C") Object columnKey);

	// Views

	/**
	 * Returns a view of all mappings that have the given row key. For each row key / column key /
	 * value mapping in the table with that row key, the returned map associates the column key with
	 * the value. If no mappings in the table have the provided row key, an empty map is returned.
	 *
	 * <p>Changes to the returned map will update the underlying table, and vice versa.
	 *
	 * @param rowKey key of row to search for in the table
	 * @return the corresponding map from column keys to values
	 */
	Map<C, V> row(R rowKey);

	/**
	 * Returns a view of all mappings that have the given column key. For each row key / column key /
	 * value mapping in the table with that column key, the returned map associates the row key with
	 * the value. If no mappings in the table have the provided column key, an empty map is returned.
	 *
	 * <p>Changes to the returned map will update the underlying table, and vice versa.
	 *
	 * @param columnKey key of column to search for in the table
	 * @return the corresponding map from row keys to values
	 */
	Map<R, V> column(C columnKey);

	/**
	 * Returns a set of all row key / column key / value triplets. Changes to the returned set will
	 * update the underlying table, and vice versa. The cell set does not support the {@code add} or
	 * {@code addAll} methods.
	 *
	 * @return set of table cells consisting of row key / column key / value triplets
	 */
	Set<Table.Cell<R, C, V>> cellSet();

	/**
	 * Returns a set of row keys that have one or more values in the table. Changes to the set will
	 * update the underlying table, and vice versa.
	 *
	 * @return set of row keys
	 */
	Set<R> rowKeySet();

	/**
	 * Returns a set of column keys that have one or more values in the table. Changes to the set will
	 * update the underlying table, and vice versa.
	 *
	 * @return set of column keys
	 */
	Set<C> columnKeySet();

	/**
	 * Returns a collection of all values, which may contain duplicates. Changes to the returned
	 * collection will update the underlying table, and vice versa.
	 *
	 * @return collection of values
	 */
	Collection<V> values();

	/**
	 * Returns a view that associates each row key with the corresponding map from column keys to
	 * values. Changes to the returned map will update this table. The returned map does not support
	 * {@code put()} or {@code putAll()}, or {@code setValue()} on its entries.
	 *
	 * <p>In contrast, the maps returned by {@code rowMap().get()} have the same behavior as those
	 * returned by {@link #row}. Those maps may support {@code setValue()}, {@code put()}, and {@code
	 * putAll()}.
	 *
	 * @return a map view from each row key to a secondary map from column keys to values
	 */
	Map<R, Map<C, V>> rowMap();

	/**
	 * Returns a view that associates each column key with the corresponding map from row keys to
	 * values. Changes to the returned map will update this table. The returned map does not support
	 * {@code put()} or {@code putAll()}, or {@code setValue()} on its entries.
	 *
	 * <p>In contrast, the maps returned by {@code columnMap().get()} have the same behavior as those
	 * returned by {@link #column}. Those maps may support {@code setValue()}, {@code put()}, and
	 * {@code putAll()}.
	 *
	 * @return a map view from each column key to a secondary map from row keys to values
	 */
	Map<C, Map<R, V>> columnMap();
}
