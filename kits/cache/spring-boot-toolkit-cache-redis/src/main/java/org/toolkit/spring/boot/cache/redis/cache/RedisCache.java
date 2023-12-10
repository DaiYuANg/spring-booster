package org.toolkit.spring.boot.cache.redis.cache;

import com.google.auto.factory.AutoFactory;

@AutoFactory
public class RedisCache<K, V>{
//	private final String cacheName;
//
//	private final BoundHashOperations<String, K, V> ops;
//
//	public RedisCache(@NonNull @NotNull RedisTemplate<String, V> template, @NonNull String cacheName) {
//		this.cacheName = cacheName;
//		ops = template.boundHashOps(cacheName);
//	}
//
//
//	public V get(K k) {
//		return ops.get(k);
//	}
//
//
//	public Map<K, V> getAll(@NotNull Set<? extends K> set) {
//		val keys = set.stream().map(k -> (K) k).toList();
//		val values = Optional.ofNullable(ops.multiGet(keys)).orElse(new ArrayList<>());
//		val result = new HashMap<K, V>(Map.of());
//		IntStream.range(0, keys.size()).forEach(i -> result.put(keys.get(i), values.get(i)));
//		return result;
//	}
//
//
//	public boolean containsKey(K k) {
//		return Boolean.TRUE.equals(ops.hasKey(k));
//	}
//
//
//	public void loadAll(Set<? extends K> set, boolean b, CompletionListener completionListener) {}
//
//
//	public void put(K k, V v) {
//		ops.put(k, v);
//	}
//
//
//	public V getAndPut(K k, V v) {
//		put(k, v);
//		return v;
//	}
//
//
//	public void putAll(Map<? extends K, ? extends V> map) {
//		ops.putAll(map);
//	}
//
//
//	public boolean putIfAbsent(K k, V v) {
//		return Boolean.TRUE.equals(ops.putIfAbsent(k, v));
//	}
//
//
//	public void remove(K k) {
//		ops.delete(k);
//	}
//
//
//	public boolean remove(K k, V v) {
//		ops.delete(k);
//		return true;
//	}
//
//
//	public V getAndRemove(K k) {
//		val v = ops.get(k);
//		ops.delete(k);
//		return v;
//	}
//
//
//	public boolean replace(K k, V v, V v1) {
//		return false;
//	}
//
//
//	public boolean replace(K k, V v) {
//		return false;
//	}
//
//
//	public V getAndReplace(K k, V v) {
//		return null;
//	}
//
//
//	public void removeAll(Set<? extends K> set) {}
//
//
//	public void removeAll() {}
//
//
//	public void clear() {
//		val keys = ops.keys();
//		ops.delete(keys);
//	}
//
//
//	public <C extends Configuration<K, V>> C getConfiguration(Class<C> aClass) {
//		return null;
//	}
//
//
//	public <T> T invoke(K k, EntryProcessor<K, V, T> entryProcessor, Object... objects) throws EntryProcessorException {
//		return null;
//	}
//
//
//	public <T> Map<K, EntryProcessorResult<T>> invokeAll(
//			Set<? extends K> set, EntryProcessor<K, V, T> entryProcessor, Object... objects) {
//		return null;
//	}
//
//
//	public String getName() {
//		return cacheName;
//	}
//
//
//	public CacheManager getCacheManager() {
//		return null;
//	}
//
//
//	public void close() {}
//
//
//	public boolean isClosed() {
//		return false;
//	}
//
//
//	public <T> T unwrap(Class<T> aClass) {
//		return null;
//	}
//
//
//	public void registerCacheEntryListener(CacheEntryListenerConfiguration<K, V> cacheEntryListenerConfiguration) {}
//
//
//	public void deregisterCacheEntryListener(CacheEntryListenerConfiguration<K, V> cacheEntryListenerConfiguration) {}
//
//
//	public Iterator<Map.Entry<K, V>> iterator() {
//		return null;
//	}
}
