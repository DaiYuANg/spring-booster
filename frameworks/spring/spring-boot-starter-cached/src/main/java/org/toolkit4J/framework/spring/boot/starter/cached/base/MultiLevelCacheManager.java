package org.toolkit4J.framework.spring.boot.starter.cached.base;

import lombok.ToString;

import javax.cache.CacheManager;
import javax.cache.Caching;
import javax.cache.configuration.MutableConfiguration;
import java.util.concurrent.CopyOnWriteArraySet;

@ToString
public class MultiLevelCacheManager {

    private final CopyOnWriteArraySet<javax.cache.CacheManager> cacheManagers = new CopyOnWriteArraySet<>();

    public MultiLevelCacheManager() {
        Caching.getCachingProviders().forEach(cachingProvider ->
                cacheManagers.add(cachingProvider.getCacheManager()));
    }

    public void createCache(String cacheName) {
//        new MutableConfiguration<Object,Object>().set
        for (CacheManager cacheManager : cacheManagers) {
            cacheManager.createCache(cacheName,
                    new MutableConfiguration<>()
            );
        }
    }
}
