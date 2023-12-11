package org.toolkit.spring.boot.cache.configurations;

import jakarta.annotation.Resource;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.toolkit.spring.boot.cache.api.Cache;

@AutoConfiguration
@Slf4j
public class AdapterAutoConfiguration {

	@Resource
	private ApplicationContext context;

	@Bean
	public ConcurrentMap<String, Cache<?, ?>> cachedAdapterConcurrentMap() {
		return context.getBeansOfType(Cache.class).entrySet().stream()
				.collect(Collectors.toConcurrentMap(Map.Entry::getKey, entry -> (Cache<?, ?>) entry.getValue()));
	}
}
