package org.toolkit.spring.boot.minio.configurations;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.toolkit.spring.boot.minio.configurations.properties.MinioConfigurationProperties;

@AutoConfiguration
@Slf4j
@ComponentScan("org.toolkit.spring.boot.minio.**.*")
public class MinioWebConfiguration implements WebMvcConfigurer {

	@Resource
	private MinioConfigurationProperties minioConfigurationProperties;

	@PostConstruct
	public void init() {
		log.atInfo().log("Minio Web config executing");
	}
}
