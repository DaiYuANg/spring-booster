package org.toolkit.spring.boot.starter.cache.configurations;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.toolkit.spring.boot.starter.cache.base.MultiLevelCacheManager;

@AutoConfiguration
@EnableConfigurationProperties(CachedConfigurationProperties.class)
public class CachedConfiguration {
	@Bean
	MultiLevelCacheManager multiLevelCacheManager() {
		return new MultiLevelCacheManager();
	}

}
