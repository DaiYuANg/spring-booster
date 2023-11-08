package org.toolkit.spring.boot.starter.cache.adapters;

import java.time.Duration;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.data.redis.core.RedisTemplate;
import org.toolkit.spring.boot.starter.cache.base.CachedAdapter;

public class RedisAdapter<K, V> implements CachedAdapter<K, V> {

	private K key;
	private RedisTemplate<K, V> redisTemplate;

	public void put(V v, long offset) {
		redisTemplate.opsForValue().set(key, v, offset);
	}

	public void put(V v, @NotNull Duration duration) {
		put(v, duration.getSeconds());
	}

	public void put(V value, long timeout, @NotNull TimeUnit unit) {
		put(value, unit.toSeconds(timeout));
	}

	public int size() {
		return Optional.ofNullable(redisTemplate.opsForValue().size(key))
				.map(Math::toIntExact)
				.orElse(0);
	}

	public boolean isEmpty() {
		return size() == 0;
	}

	public boolean containsKey(Object o) {
		return Optional.ofNullable(redisTemplate.opsForValue().get(key)).isPresent();
	}

	public boolean containsValue(Object o) {
		return Optional.ofNullable(redisTemplate.opsForValue().get(key))
				.map(value -> Objects.equals(o, value))
				.orElse(false);
	}

	public V get(Object o) {
		return redisTemplate.opsForValue().get(o);
	}

	@Nullable public V put(K k, V v) {
		redisTemplate.opsForValue().set(k, v);
		return v;
	}

	public V remove(K o) {
		return redisTemplate.opsForValue().getAndDelete(o);
	}

	public void clear() {
		redisTemplate.delete(key);
	}

	public V getOrDefault(K key, V defaultValue) {
		return Optional.ofNullable(redisTemplate.opsForValue().get(key)).orElse(defaultValue);
	}

	public boolean putIfAbsent() {
		return true;
	}
}
