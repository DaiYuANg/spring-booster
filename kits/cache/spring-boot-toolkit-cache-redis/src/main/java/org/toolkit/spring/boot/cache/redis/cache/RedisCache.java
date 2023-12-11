package org.toolkit.spring.boot.cache.redis.cache;

import com.google.auto.factory.AutoFactory;
import org.springframework.data.redis.core.RedisTemplate;

@AutoFactory
public class RedisCache<K, V>  {

    RedisTemplate<K,V> template;

}
