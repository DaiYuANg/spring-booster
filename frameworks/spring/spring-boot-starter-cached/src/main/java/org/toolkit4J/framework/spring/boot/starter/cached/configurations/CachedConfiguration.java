package org.toolkit4J.framework.spring.boot.starter.cached.configurations;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.toolkit4J.framework.spring.boot.starter.cached.base.MultiLevelCacheManager;

@AutoConfiguration
@EnableConfigurationProperties(CachedConfigurationProperties.class)
public class CachedConfiguration {
    @Bean
    MultiLevelCacheManager cm(){
        return new MultiLevelCacheManager();
    };

//    @Bean
//    public CacheManager cacheManager() {
//        CacheManager cacheManager = Caching.getCachingProvider().getCacheManager();
//        MutableConfiguration<Object, Object> cacheConfig = new MutableConfiguration<>();
//        cacheConfig.setStatisticsEnabled(true);
//        cacheConfig.setExpiryPolicyFactory(CreatedExpiryPolicy.factoryOf(Duration.ETERNAL));
//        javax.cache.Cache<Object, Object> cache = cacheManager.createCache("myCache", cacheConfig);
//        return cacheManager;
//    }
}
