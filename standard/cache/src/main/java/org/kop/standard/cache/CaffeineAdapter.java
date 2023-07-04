package org.kop.standard.cache;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import org.jetbrains.annotations.NotNull;
import org.kop.standard.cache.base.CacheConfig;
import org.kop.standard.cache.base.ICache;

import java.time.Duration;

public class CaffeineAdapter<K, V> implements ICache<K, V> {
    private final Cache<K, V> cache;

    public CaffeineAdapter(CacheConfig config) {
        cache = Caffeine.newBuilder().build();
    }

    @Override
    public void put(K k, V v) {
        cache.put(k, v);
        System.gc();
    }

    @Override
    public void put(K k, V v, Duration d) {

    }

    @Override
    public V get(K k) {
        return null;
    }

    @Override
    public void remove(K k) {

    }

    @Override
    public void removeAll() {
        cache.invalidateAll();
    }

    @Override
    public boolean contains(Class cls, Object primaryKey) {
        return false;
    }

    @Override
    public void evict(Class cls, Object primaryKey) {

    }

    @Override
    public void evict(Class cls) {

    }

    @Override
    public void evictAll() {

    }

    @Override
    public <T> T unwrap(Class<T> cls) {
        return null;
    }

    @Override
    public int compareTo(@NotNull ICache<K, V> o) {
        return 0;
    }
}
