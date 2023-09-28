package org.toolkit.spring.boot.starter.minio.configurations;

import static org.springframework.web.servlet.function.RequestPredicates.accept;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.function.*;
import org.springframework.web.servlet.handler.SimpleUrlHandlerMapping;
import org.toolkit.spring.boot.starter.minio.functional.MinioTemplate;
import org.toolkit.spring.boot.starter.minio.handlers.MinioHandler;
import org.toolkit.spring.boot.starter.minio.repositories.MinioResourceAccessEntityRepository;

@AutoConfiguration
@Slf4j
public class MinioWebConfiguration implements WebMvcConfigurer {

	private static final RequestPredicate ACCEPT_JSON = accept(MediaType.APPLICATION_JSON);

	@Resource
	private MinioConfigurationProperties minioConfigurationProperties;

	@Resource
	private MinioResourceAccessEntityRepository minioResourceAccessEntityRepository;

	@Resource
	private MinioTemplate minioTemplate;

	@Resource
	private MinioHandler myHandler;

	@PostConstruct
	public void init() {
		System.err.println(minioResourceAccessEntityRepository.findAll());
		log.atDebug().log("Minio Web config executing");
	}

	@Bean
	public SimpleUrlHandlerMapping simpleUrlHandlerMapping() {
		val handlerMapping = new SimpleUrlHandlerMapping();
		// Create a map to map URL paths to handler beans
		Map<String, Object> urlMap = new HashMap<>();
		urlMap.put("/my-handler", myHandler);

		// Set the URL map in the handler mapping
		handlerMapping.setUrlMap(urlMap);

		// Set order if needed
		handlerMapping.setOrder(Ordered.HIGHEST_PRECEDENCE);

		return handlerMapping;
	}
}
