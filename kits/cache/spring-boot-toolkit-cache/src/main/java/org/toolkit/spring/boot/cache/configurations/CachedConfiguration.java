package org.toolkit.spring.boot.cache.configurations;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.toolkit.spring.boot.cache.base.MultiLevelCacheManager;

@AutoConfiguration
@EnableConfigurationProperties(CachedConfigurationProperties.class)
public class CachedConfiguration {
	@Bean
	public MultiLevelCacheManager multiLevelCacheManager() {
		return new MultiLevelCacheManager();
	}
}
