package org.toolkit4J.libs.cache.simple

import net.jodah.expiringmap.ExpiringMap
import javax.cache.Cache
import javax.cache.Cache.Entry
import javax.cache.CacheManager
import javax.cache.configuration.CacheEntryListenerConfiguration
import javax.cache.configuration.Configuration
import javax.cache.integration.CompletionListener
import javax.cache.processor.EntryProcessor
import javax.cache.processor.EntryProcessorResult

class SimpleCache<K, V>(private val name: String) : Cache<K, V> {
    private var store = ExpiringMap.builder()
        .variableExpiration()
        .build<K, V>()

    override fun iterator(): MutableIterator<Entry<K, V>> {
//        store.entries.map { mutableEntry ->  {
//           val entry:Entry<K,V> = object :Entry<K,V>{
//               override fun getKey(): K {
//                  return mutableEntry.key
//               }
//
//               override fun getValue(): V {
//                   return mutableEntry.value
//               }
//
//               override fun <T : Any?> unwrap(clazz: Class<T>?): T {
//                   TODO("Not yet implemented")
//               }
//           }
//        }}.m.iterator();
        TODO("Not yet implemented")
    }

    override fun close() {
        store = null
    }

    override fun removeAll() {
        clear()
    }

    override fun clear() {
        store.clear()
    }

    override fun getName(): String {
        return name;
    }

    override fun getCacheManager(): CacheManager {
        TODO("Not yet implemented")
    }

    override fun isClosed(): Boolean {
        return store == null
    }

    override fun <T : Any?> unwrap(clazz: Class<T>?): T {
        TODO("Not yet implemented")
    }

    override fun deregisterCacheEntryListener(cacheEntryListenerConfiguration: CacheEntryListenerConfiguration<K, V>?) {
        TODO("Not yet implemented")
    }

    override fun registerCacheEntryListener(cacheEntryListenerConfiguration: CacheEntryListenerConfiguration<K, V>?) {
        TODO("Not yet implemented")
    }

    override fun <T : Any?> invokeAll(
        keys: MutableSet<out K>?,
        entryProcessor: EntryProcessor<K, V, T>?,
        vararg arguments: Any?
    ): MutableMap<K, EntryProcessorResult<T>> {
        TODO("Not yet implemented")
    }

    override fun <T : Any?> invoke(key: K, entryProcessor: EntryProcessor<K, V, T>?, vararg arguments: Any?): T {
        TODO("Not yet implemented")
    }

    override fun <C : Configuration<K, V>?> getConfiguration(clazz: Class<C>?): C {
        TODO("Not yet implemented")
    }

    override fun removeAll(keys: MutableSet<out K>?) {
        keys?.forEach { k: K -> store.remove(k) }
    }

    override fun getAndReplace(key: K, value: V): V {
        TODO("Not yet implemented")
    }

    override fun replace(key: K, value: V): Boolean {
        return store.replace(key, value) == null
    }

    override fun replace(key: K, oldValue: V, newValue: V): Boolean {
        TODO("Not yet implemented")
    }

    override fun getAndRemove(key: K): V {
        return store.remove(key)!!
    }

    override fun remove(key: K, oldValue: V): Boolean {
        return when (oldValue) {
            store.get(key) -> store.remove(key) == null
            else -> false
        }
    }

    override fun remove(key: K): Boolean {
        return store.remove(key) == null
    }

    override fun putIfAbsent(key: K, value: V): Boolean {
        return store.putIfAbsent(key, value) == null
    }

    override fun putAll(map: MutableMap<out K, out V>?) {
        map?.let { store.putAll(it) }
    }

    override fun getAndPut(key: K, value: V): V {
        TODO("Not yet implemented")
    }

    override fun put(key: K, value: V) {
        store.put(key, value)
    }

    override fun loadAll(
        keys: MutableSet<out K>?,
        replaceExistingValues: Boolean,
        completionListener: CompletionListener?
    ) {
        TODO("Not yet implemented")
    }

    override fun containsKey(key: K): Boolean {
        return store.containsKey(key)
    }

    override fun getAll(keys: MutableSet<out K>?): MutableMap<K, V> {
        return store.filterKeys { k: K -> keys!!.contains(k) }.toMutableMap()
    }

    override fun get(key: K): V {
        return store.get(key)!!
    }
}