/* (C)2024*/
package org.spring.boost.minio.autoconfigure;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.apache.tika.Tika;
import org.spring.boost.minio.factory.MinioAdminClientBeanFactoryPostProcessor;
import org.spring.boost.minio.factory.MinioClientBeanFactoryPostProcessor;
import org.spring.boost.minio.factory.MinioTemplateBeanFactoryPostProcessor;
import org.spring.boost.minio.properties.MinioConfigurationProperties;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;

@AutoConfiguration
@EnableConfigurationProperties(MinioConfigurationProperties.class)
@Slf4j
public class MinioAutoConfigure {

	@Resource
	private MinioConfigurationProperties properties;

	@Bean
	public Tika tika() {
		return new Tika();
	}

	@Bean
	public MinioClientBeanFactoryPostProcessor minioClientBeanFactoryPostProcessor() {
		return new MinioClientBeanFactoryPostProcessor(properties);
	}

	@Bean
	public MinioAdminClientBeanFactoryPostProcessor minioAdminClientBeanFactoryPostProcessor() {
		return new MinioAdminClientBeanFactoryPostProcessor(properties);
	}

	@Bean
	public MinioTemplateBeanFactoryPostProcessor minioTemplateBeanFactoryPostProcessor(
			Tika tika, ApplicationEventPublisher eventPublisher) {
		return MinioTemplateBeanFactoryPostProcessor.builder()
				.properties(properties)
				.tika(tika)
				.eventPublisher(eventPublisher)
				.build();
	}
}
