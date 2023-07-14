package org.toolkit4J.standard.cache.base;

import org.jetbrains.annotations.NotNull;

import java.io.Serializable;
import java.time.Duration;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

public interface Cache<K extends Serializable, V extends Serializable> extends Iterable<Cache.Entry<K, V>>, Comparable<K>, Cloneable {
    /**
     * Put a cache into cache instance
     * @param key cache key
     * @param value cache value
     */
    void put(K key, V value);

    void put(K key, V value,long duration,TimeUnit timeUnit);

    void put(K key, V value,Duration duration);

    boolean putIfAbsent(K key, V value);

    V getOrPut(K key, V value);

    V getAndRemove(K key);

    boolean hasKey(K key);

    boolean hasValue(V value);

    Optional<V> get(K key);

    @NotNull
    Set<K> getAllOfKey();

    @NotNull
    Collection<V> getAllOfValue();

    void remove(K key);

    void removeAll(List<K> keys);

    void removeAll(Set<K> keys);

    void removeAll(K[] keys);

    void clear();

    Optional<V> removeAndGet(K key);

    void expire(K key, long t, TimeUnit unit);

    void expire(K key, Duration duration);

    int size();

    interface Entry<K, V> {
        K getKey();

        V getValue();

        <T> T unwrap(Class<T> clazz);
    }
}
