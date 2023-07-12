package org.toolkit4j.standard.cache.base;

import jakarta.persistence.Cache;

import java.time.Duration;

public interface ICache<K, V> extends Cache, Comparable<ICache<K, V>> {
    void put(K k, V v);

    void put(K k, V v, Duration d);

    V get(K k);

    void remove(K k);

    void removeAll();
}