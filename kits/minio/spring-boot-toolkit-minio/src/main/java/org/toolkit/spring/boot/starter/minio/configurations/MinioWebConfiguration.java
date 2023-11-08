package org.toolkit.spring.boot.starter.minio.configurations;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.toolkit.spring.boot.starter.minio.configurations.properties.MinioConfigurationProperties;
import org.toolkit.spring.boot.starter.minio.interceptor.PreviewInterceptor;

@AutoConfiguration
@Slf4j
public class MinioWebConfiguration implements WebMvcConfigurer {

	@Resource
	private MinioConfigurationProperties minioConfigurationProperties;

	@Resource
	private PreviewInterceptor previewInterceptor;

	@PostConstruct
	public void init() {
		log.atInfo().log("Minio Web config executing");
	}

	@Override
	public void addInterceptors(@NotNull InterceptorRegistry registry) {
		registry.addInterceptor(previewInterceptor)
				.order(0)
				.addPathPatterns(minioConfigurationProperties.getPreviewPattern());
	}
}
