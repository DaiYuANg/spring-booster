package org.toolkit.spring.boot.cache.api.configurations;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.toolkit.spring.boot.cache.api.base.MultiLevelCacheManager;

@AutoConfiguration
@EnableConfigurationProperties(CachedConfigurationProperties.class)
@Slf4j
public class CacheConfiguration {
	@Bean
	public MultiLevelCacheManager multiLevelCacheManager() {
		return new MultiLevelCacheManager();
	}
}
