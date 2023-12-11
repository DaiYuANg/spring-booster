package org.toolkit.spring.boot.cache.api;

import org.springframework.boot.autoconfigure.cache.CacheType;

public interface CacheManager {

    CacheType getCacheType();
}
