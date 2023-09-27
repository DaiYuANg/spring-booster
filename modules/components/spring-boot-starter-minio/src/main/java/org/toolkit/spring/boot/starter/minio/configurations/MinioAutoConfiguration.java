package org.toolkit.spring.boot.starter.minio.configurations;

import io.minio.BucketExistsArgs;
import io.minio.MakeBucketArgs;
import io.minio.MinioClient;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@AutoConfiguration
@EnableConfigurationProperties(MinioConfigurationProperties.class)
@Slf4j
@EntityScan("org.toolkit.spring.boot.starter.minio.entities.*")
@EnableJpaRepositories("org.toolkit.spring.boot.starter.minio.repositories")
public class MinioAutoConfiguration implements WebMvcConfigurer {

	@Resource
	private MinioConfigurationProperties minioConfigurationProperties;

	@PostConstruct
	public void init() {
		log.atDebug().log("Minio Auto Configuration Executing");
		log.atInfo().log(minioConfigurationProperties.toString());
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
		val isBucketExists = client.bucketExists(BucketExistsArgs.builder()
				.bucket(minioConfigurationProperties.getDefaultBucket())
				.build());
		log.atInfo().log("bucket exists:{}", isBucketExists);
		if (!isBucketExists) {
			client.makeBucket(MakeBucketArgs.builder()
					.bucket(minioConfigurationProperties.getDefaultBucket())
					.build());
		}
		return client;
	}
}
