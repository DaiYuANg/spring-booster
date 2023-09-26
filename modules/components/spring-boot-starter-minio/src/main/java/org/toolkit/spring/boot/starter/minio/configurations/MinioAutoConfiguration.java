package org.toolkit.spring.boot.starter.minio.configurations;

import io.minio.BucketExistsArgs;
import io.minio.MakeBucketArgs;
import io.minio.MinioClient;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.jetbrains.annotations.NotNull;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.toolkit.spring.boot.starter.minio.interceptor.PreviewInterceptor;

@AutoConfiguration
@EnableConfigurationProperties(MinioConfigurationProperties.class)
@Slf4j
public class MinioAutoConfiguration implements WebMvcConfigurer {

	@Resource
	private MinioConfigurationProperties minioConfigurationProperties;

	@PostConstruct
	public void init() {
		log.info("Minio Auto Configuration Executing");
	}

	@SneakyThrows
	@Bean
	@ConditionalOnMissingBean
	@ConditionalOnClass(MinioClient.class)
	public MinioClient minioClient() {
		val client = MinioClient.builder()
				.credentials(minioConfigurationProperties.getAccessKey(), minioConfigurationProperties.getSecretKey())
				.endpoint(minioConfigurationProperties.getEndpoint())
				.build();
		if (!client.bucketExists(BucketExistsArgs.builder()
				.bucket(minioConfigurationProperties.getDefaultBucket())
				.build())) {
			client.makeBucket(MakeBucketArgs.builder()
					.bucket(minioConfigurationProperties.getDefaultBucket())
					.build());
		}
		return client;
	}

	@Override
	public void addInterceptors(@NotNull InterceptorRegistry registry) {
		registry.addInterceptor(new PreviewInterceptor(minioConfigurationProperties.getAccessPrefix()));
	}
}
