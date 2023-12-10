package org.toolkit.spring.boot.cache.redis.cache;

import java.util.*;
import java.util.stream.IntStream;
import javax.cache.CacheManager;
import javax.cache.configuration.CacheEntryListenerConfiguration;
import javax.cache.configuration.Configuration;
import javax.cache.integration.CompletionListener;
import javax.cache.processor.EntryProcessor;
import javax.cache.processor.EntryProcessorException;
import javax.cache.processor.EntryProcessorResult;
import lombok.NonNull;
import lombok.val;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.redis.core.*;
import org.toolkit.spring.boot.cache.api.base.Cache;

public class RedisCache<K, V> implements Cache<K, V> {
	private final String cacheName;

	private final BoundHashOperations<String, K, V> ops;

	public RedisCache(@NonNull @NotNull RedisTemplate<String, V> template, @NonNull String cacheName) {
		this.cacheName = cacheName;
		ops = template.boundHashOps(cacheName);
	}

	@Override
	public V get(K k) {
		return ops.get(k);
	}

	@Override
	public Map<K, V> getAll(@NotNull Set<? extends K> set) {
		val keys = set.stream().map(k -> (K) k).toList();
		val values = Optional.ofNullable(ops.multiGet(keys)).orElse(new ArrayList<>());
		val result = new HashMap<K, V>(Map.of());
		IntStream.range(0, keys.size()).forEach(i -> result.put(keys.get(i), values.get(i)));
		return result;
	}

	@Override
	public boolean containsKey(K k) {
		return Boolean.TRUE.equals(ops.hasKey(k));
	}

	@Override
	public void loadAll(Set<? extends K> set, boolean b, CompletionListener completionListener) {}

	@Override
	public void put(K k, V v) {
		ops.put(k, v);
	}

	@Override
	public V getAndPut(K k, V v) {
		put(k, v);
		return v;
	}

	@Override
	public void putAll(Map<? extends K, ? extends V> map) {
		ops.putAll(map);
	}

	@Override
	public boolean putIfAbsent(K k, V v) {
		return Boolean.TRUE.equals(ops.putIfAbsent(k, v));
	}

	@Override
	public boolean remove(K k) {
		return ops.delete(k) == null;
	}

	@Override
	public boolean remove(K k, V v) {
		ops.delete(k);
		return true;
	}

	@Override
	public V getAndRemove(K k) {
		val v = ops.get(k);
		ops.delete(k);
		return v;
	}

	@Override
	public boolean replace(K k, V v, V v1) {
		return false;
	}

	@Override
	public boolean replace(K k, V v) {
		return false;
	}

	@Override
	public V getAndReplace(K k, V v) {
		return null;
	}

	@Override
	public void removeAll(Set<? extends K> set) {}

	@Override
	public void removeAll() {}

	@Override
	public void clear() {
		val keys = ops.keys();
		ops.delete(keys);
	}

	@Override
	public <C extends Configuration<K, V>> C getConfiguration(Class<C> aClass) {
		return null;
	}

	@Override
	public <T> T invoke(K k, EntryProcessor<K, V, T> entryProcessor, Object... objects) throws EntryProcessorException {
		return null;
	}

	@Override
	public <T> Map<K, EntryProcessorResult<T>> invokeAll(
			Set<? extends K> set, EntryProcessor<K, V, T> entryProcessor, Object... objects) {
		return null;
	}

	@Override
	public String getName() {
		return cacheName;
	}

	@Override
	public CacheManager getCacheManager() {
		return null;
	}

	@Override
	public void close() {}

	@Override
	public boolean isClosed() {
		return false;
	}

	@Override
	public <T> T unwrap(Class<T> aClass) {
		return null;
	}

	@Override
	public void registerCacheEntryListener(CacheEntryListenerConfiguration<K, V> cacheEntryListenerConfiguration) {}

	@Override
	public void deregisterCacheEntryListener(CacheEntryListenerConfiguration<K, V> cacheEntryListenerConfiguration) {}

	@Override
	public Iterator<Entry<K, V>> iterator() {
		return null;
	}
}
