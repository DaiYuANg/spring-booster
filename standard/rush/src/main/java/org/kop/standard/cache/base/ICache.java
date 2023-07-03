package org.kop.standard.cache.base;

import jakarta.persistence.Cache;

import java.time.Duration;

public interface ICache<K, V> extends Cache {
    void put(K k, V v);

    void put(K k, V v, Duration d);

    V get(K k);

    void remove(K k);
}