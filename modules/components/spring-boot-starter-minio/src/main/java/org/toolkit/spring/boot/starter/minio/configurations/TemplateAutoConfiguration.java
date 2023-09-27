package org.toolkit.spring.boot.starter.minio.configurations;

import io.minio.MinioClient;
import jakarta.annotation.Resource;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.toolkit.spring.boot.starter.minio.functional.MinioTemplate;

@AutoConfiguration
public class TemplateAutoConfiguration {

	@Resource
	private MinioClient minioClient;

	@Bean
	@ConditionalOnMissingBean
	@ConditionalOnClass(MinioClient.class)
	public MinioTemplate minioTemplate() {
		return new MinioTemplate(minioClient);
	}
}
