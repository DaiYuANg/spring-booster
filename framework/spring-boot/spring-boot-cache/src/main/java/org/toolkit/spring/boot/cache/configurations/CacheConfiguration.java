package org.toolkit.spring.boot.cache.configurations;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.toolkit.spring.boot.cache.api.MultiLevelCacheManager;

@AutoConfiguration
@EnableConfigurationProperties(CachedConfigurationProperties.class)
@Slf4j
public class CacheConfiguration {
	@Bean
	public MultiLevelCacheManager multiLevelCacheManager() {
		return new MultiLevelCacheManager();
	}

	@Bean
	public SpelExpressionParser spelExpressionParser() {
		return new SpelExpressionParser();
	}
}
