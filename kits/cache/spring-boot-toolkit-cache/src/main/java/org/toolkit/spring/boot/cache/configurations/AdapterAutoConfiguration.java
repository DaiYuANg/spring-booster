package org.toolkit.spring.boot.cache.configurations;

import jakarta.annotation.Resource;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.toolkit.spring.boot.cache.base.CachedAdapter;

@AutoConfiguration
@Slf4j
public class AdapterAutoConfiguration {

	@Resource
	private ApplicationContext context;

	@Bean
	public ConcurrentMap<String, CachedAdapter<?, ?>> cachedAdapterConcurrentMap() {
		return context.getBeansOfType(CachedAdapter.class).entrySet().stream()
				.collect(
						Collectors.toConcurrentMap(Map.Entry::getKey, entry -> (CachedAdapter<?, ?>) entry.getValue()));
	}
}