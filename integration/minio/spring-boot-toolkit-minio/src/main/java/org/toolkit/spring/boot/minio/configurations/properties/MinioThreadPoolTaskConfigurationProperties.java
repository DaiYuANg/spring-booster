package org.toolkit.spring.boot.minio.configurations.properties;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "toolkit.minio.thread-pool")
@Getter
@Setter
@ToString
public class MinioThreadPoolTaskConfigurationProperties {
	private Integer coreSize = Runtime.getRuntime().availableProcessors();

	private Integer maxSize = coreSize * 2 + 1;

	private Integer queueCapacity = maxSize * 10;

	private Integer keepAliveSeconds = 60;

	private String prefix = "Toolkit-Minio-";
}
