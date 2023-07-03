package org.kop.standard.cache.base;


import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.stream.Collectors;

public class CacheManager<K, V> {
    private final PriorityQueue<ICache<K, V>> cacheQueue = new PriorityQueue<>();

    public CacheManager(@NotNull List<ICache<K, V>> caches) {
        caches.forEach(cacheQueue::offer);
    }

    public CacheManager(ICache<K, V> cache) {
        this(Collections.singletonList(cache));
    }

    @SafeVarargs
    public CacheManager(ICache<K, V>... cache) {
        this(Arrays.stream(cache).collect(Collectors.toList()));
    }

    public void put(K k, V v) {
        cacheQueue.stream().filter(c -> Objects.isNull(c.get(k)))
                .forEach(c -> c.put(k, v));
    }

    public V get(K k) {
        return cacheQueue.stream().filter(kviCache -> !Objects.isNull(kviCache.get(k)))
                .findFirst()
                .map(kviCache -> kviCache.get(k))
                .orElse(null);
    }

    public Optional<V> getIfAbsent(K k) {
        return Optional.ofNullable(get(k));
    }
}
