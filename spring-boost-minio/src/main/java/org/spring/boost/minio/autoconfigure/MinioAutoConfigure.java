/* (C)2024*/
package org.spring.boost.minio.autoconfigure;

import java.util.Objects;
import lombok.extern.slf4j.Slf4j;
import org.apache.tika.Tika;
import org.spring.boost.minio.factory.MinioAdminClientBeanFactoryPostProcessor;
import org.spring.boost.minio.factory.MinioClientBeanFactoryPostProcessor;
import org.spring.boost.minio.factory.MinioTemplateBeanFactoryPostProcessor;
import org.spring.boost.minio.properties.MinioConfigurationProperties;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.DependsOn;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.Environment;

@AutoConfiguration
@EnableConfigurationProperties(MinioConfigurationProperties.class)
@Slf4j
@Order
public class MinioAutoConfigure {

	private MinioConfigurationProperties minioConfigurationProperties;

	@Bean
	public Tika tika() {
		return new Tika();
	}

	@Bean
	public MinioClientBeanFactoryPostProcessor minioClientBeanFactoryPostProcessor(Environment environment) {
		return new MinioClientBeanFactoryPostProcessor(bindMinioConfigurationProperties(environment));
	}

	@Bean
	public MinioAdminClientBeanFactoryPostProcessor minioAdminClientBeanFactoryPostProcessor(Environment environment) {
		return new MinioAdminClientBeanFactoryPostProcessor(bindMinioConfigurationProperties(environment));
	}

	@Bean
	@DependsOn({"minioClientBeanFactoryPostProcessor", "minioAdminClientBeanFactoryPostProcessor"})
	public MinioTemplateBeanFactoryPostProcessor minioTemplateBeanFactoryPostProcessor(
			Tika tika, ApplicationEventPublisher eventPublisher, Environment environment) {
		return MinioTemplateBeanFactoryPostProcessor.builder()
				.properties(bindMinioConfigurationProperties(environment))
				.tika(tika)
				.eventPublisher(eventPublisher)
				.build();
	}

	private MinioConfigurationProperties bindMinioConfigurationProperties(Environment environment) {
		if (Objects.isNull(minioConfigurationProperties)) {
			minioConfigurationProperties = Binder.get(environment)
					.bindOrCreate(MinioConfigurationProperties.prefix, MinioConfigurationProperties.class);
			return minioConfigurationProperties;
		}
		return minioConfigurationProperties;
	}
}
