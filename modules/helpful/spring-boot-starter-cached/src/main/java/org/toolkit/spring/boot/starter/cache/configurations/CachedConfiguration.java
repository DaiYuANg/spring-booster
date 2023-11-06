package org.toolkit.spring.boot.starter.cache.configurations;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.RedisTemplate;
import org.toolkit.spring.boot.starter.cache.adapters.RedisAdapter;
import org.toolkit.spring.boot.starter.cache.base.MultiLevelCacheManager;

@AutoConfiguration
@EnableConfigurationProperties(CachedConfigurationProperties.class)
public class CachedConfiguration {
	@Bean
	public MultiLevelCacheManager multiLevelCacheManager() {
		return new MultiLevelCacheManager();
	}
}
