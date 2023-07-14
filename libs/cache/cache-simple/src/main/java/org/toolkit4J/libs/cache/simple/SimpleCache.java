package org.toolkit4J.libs.cache.simple;

import lombok.ToString;
import lombok.val;
import net.jodah.expiringmap.ExpirationPolicy;
import net.jodah.expiringmap.ExpiringMap;
import org.jetbrains.annotations.NotNull;
import org.toolkit4J.standard.cache.base.Cache;

import java.io.Serializable;
import java.time.Duration;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.TimeUnit;

@ToString
public class SimpleCache<K extends Serializable & Comparable<K>, V extends Serializable> implements Cache<K, V> {
    private final ExpiringMap<K, V> internal;

    SimpleCache() {
        internal = ExpiringMap.builder()
                .expirationPolicy(ExpirationPolicy.CREATED)
                .variableExpiration()
                .build();
    }


    @Override
    public void put(K key, V value) {
        internal.put(key, value);
    }

    @Override
    public void put(K key, V value, long duration, TimeUnit timeUnit) {
        internal.put(key, value, duration, timeUnit);
    }

    @Override
    public void put(K key, V value, @NotNull Duration duration) {
        internal.put(key, value, duration.toNanos(), TimeUnit.NANOSECONDS);
    }

    @Override
    public boolean putIfAbsent(K key, V value) {
        return Objects.isNull(internal.putIfAbsent(key, value));
    }

    @Override
    public V getOrPut(K key, V value) {
        val v = internal.get(key);
        if (Objects.nonNull(v)) return v;
        return internal.put(key, value);
    }

    @Override
    public V getAndRemove(K key) {
        val value = internal.get(key);
        if (Objects.isNull(value)) return null;
        internal.remove(key);
        return value;
    }

    @Override
    public boolean hasKey(K key) {
        return internal.containsKey(key);
    }

    @Override
    public boolean hasValue(V value) {
        return internal.containsKey(value);
    }

    @Override
    public Optional<V> get(K key) {
        return Optional.of(internal.get(key));
    }

    @Override
    public @NotNull Set<K> getAllOfKey() {
        return internal.keySet();
    }

    @Override
    public @NotNull Collection<V> getAllOfValue() {
        return internal.values();
    }

    @Override
    public void remove(K key) {
        internal.remove(key);
    }

    @Override
    public void removeAll(@NotNull List<K> keys) {
        keys.stream().distinct().forEach(internal::remove);
    }

    @Override
    public void removeAll(@NotNull Set<K> keys) {
        keys.forEach(internal::remove);
    }

    @Override
    public void removeAll(K[] keys) {
        Arrays.stream(keys).forEach(internal::remove);
    }

    @Override
    public void clear() {
        internal.clear();
    }

    @Override
    public Optional<V> removeAndGet(K key) {
        val value = internal.get(key);
        internal.remove(key);
        return Optional.of(value);
    }

    @Override
    public void expire(K key, long t, TimeUnit unit) {
        internal.setExpiration(key, t, unit);
    }

    @Override
    public void expire(K key, @NotNull Duration duration) {
        internal.setExpiration(key, duration.toNanos(), TimeUnit.NANOSECONDS);
    }

    @Override
    public int size() {
        return internal.size();
    }

    @Override
    public int compareTo(@NotNull K o) {
        return o.hashCode();
    }

    @NotNull
    @Override
    public Iterator<Entry<K, V>> iterator() {
        return new Iterator<>() {
            @Override
            public boolean hasNext() {
                return internal.keySet().iterator().hasNext();
            }

            @Override
            public Entry<K, V> next() {
//                return internal.get(internal.keySet().iterator().next());
//                return iterator().next();
                return null;
            }
        };
    }
}