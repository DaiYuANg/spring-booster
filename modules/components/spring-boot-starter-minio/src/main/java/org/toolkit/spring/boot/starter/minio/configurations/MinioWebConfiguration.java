package org.toolkit.spring.boot.starter.minio.configurations;

import static org.springframework.web.servlet.function.RequestPredicates.accept;
import static org.springframework.web.servlet.function.RouterFunctions.route;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.function.*;
import org.toolkit.spring.boot.starter.minio.MinioController;
import org.toolkit.spring.boot.starter.minio.functional.MinioTemplate;
import org.toolkit.spring.boot.starter.minio.interceptor.PreviewInterceptor;
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

	@PostConstruct
	public void init() {
		log.atDebug().log("Minio Web config executing");
	}

	@Override
	public void addInterceptors(@NotNull InterceptorRegistry registry) {
		registry.addInterceptor(new PreviewInterceptor(minioTemplate, minioResourceAccessEntityRepository))
				.addPathPatterns(minioConfigurationProperties.getPreviewPattern());
	}

	@Bean
	public MinioController minioController() {
		return new MinioController();
	}

	@Bean
	public RouterFunction<ServerResponse> routerFunction(MinioController minioController) {
		return route().GET("/{user}", ACCEPT_JSON, request -> {
					System.err.println(request);
					return null;
				})
				.build();
	}
}
