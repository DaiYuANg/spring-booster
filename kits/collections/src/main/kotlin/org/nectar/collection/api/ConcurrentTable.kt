// (C)2023
package org.nectar.collection.api

import java.util.Optional

interface ConcurrentTable<R, C, V> {
    fun contains(
        rowKey: Any?,
        columnKey: Any?,
    ): Boolean

    fun containsRow(rowKey: Any?): Boolean

    fun containsColumn(columnKey: Any?): Boolean

    fun containsValue(value: Any?): Boolean

    //
    fun get(
        rowKey: Any?,
        columnKey: Any?,
    ): V?

    fun getOptional(
        rowKey: Any,
        columnKey: Any,
    ): Optional<V & Any> {
        return Optional.ofNullable(get(rowKey, columnKey))
    }

    val isEmpty: Boolean

    fun size(): Int

    fun clear()

    fun put(
        rowKey: R,
        columnKey: C,
        value: V,
    ): V

    fun putAll(table: ConcurrentTable<out R, out C, out V>)

    fun remove(
        rowKey: Any,
        columnKey: Any,
    ): V?

    fun removeOptional(
        rowKey: Any,
        columnKey: Any,
    ): Optional<V & Any> {
        return Optional.ofNullable(remove(rowKey, columnKey))
    }

    fun row(rowKey: R): Map<C, V>?

    fun column(columnKey: C): Map<R, V>?

    fun rowKeySet(): Set<R>

    fun columnKeySet(): Set<C>?

    fun values(): Collection<V>?

    fun rowMap(): Map<R, Map<C, V>>?
}

internal interface ConcurrentCell<R, C, V> {
    val rowKey: R

    val columnKey: C

    val value: V
}
