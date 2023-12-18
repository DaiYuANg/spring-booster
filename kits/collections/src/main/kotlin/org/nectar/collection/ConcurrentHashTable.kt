@file:JvmName("org.nectar.collection.ConcurrentHashTable")

package org.nectar.collection

import org.nectar.collection.api.ConcurrentTable
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.ConcurrentMap

class ConcurrentHashTable<R, C, V> : ConcurrentTable<R, C, V> {
    private val internal = ConcurrentHashMap<R, ConcurrentHashMap<C, V>>()

    override fun contains(
        rowKey: Any?,
        columnKey: Any?,
    ): Boolean {
        TODO("Not yet implemented")
    }

    override fun containsRow(rowKey: Any?): Boolean {
        TODO("Not yet implemented")
    }

    override fun containsColumn(columnKey: Any?): Boolean {
        TODO("Not yet implemented")
    }

    override fun containsValue(value: Any?): Boolean {
        TODO("Not yet implemented")
    }

    override fun get(
        rowKey: Any?,
        columnKey: Any?,
    ): V? {
        return internal[rowKey]?.get(columnKey)
    }

    override val isEmpty: Boolean
        get() = internal.isEmpty()

    override fun size(): Int {
        return internal.size
    }

    override fun clear() {
        internal.clear()
    }

    override fun remove(
        rowKey: Any,
        columnKey: Any,
    ): V {
        TODO("Not yet implemented")
    }

    override fun rowKeySet(): Set<R> {
        TODO("Not yet implemented")
    }

    override fun columnKeySet(): Set<C>? {
        TODO("Not yet implemented")
    }

    override fun values(): Collection<V>? {
        TODO("Not yet implemented")
    }

    override fun rowMap(): ConcurrentHashMap<R, ConcurrentHashMap<C, V>>? {
        TODO("Not yet implemented")
    }

    override fun column(columnKey: C): Map<R, V>? {
        TODO("Not yet implemented")
    }

    override fun row(rowKey: R): Map<C, V>? {
        return internal[rowKey]
    }

    override fun putAll(table: ConcurrentTable<out R, out C, out V>) {
        TODO("Not yet implemented")
    }

    override fun put(
        rowKey: R,
        columnKey: C,
        value: V,
    ): V {
        getColumnMap(rowKey)[columnKey] = value
        return value
    }

    private fun getColumnMap(rowKey: R): ConcurrentMap<C, V> {
        return internal.computeIfAbsent(rowKey) {
            ConcurrentHashMap<C, V>()
        }
    }
}
