package org.toolkit.spring.boot.starter.minio.configurations.properties;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class MinioClientConfigurationProperties {
	private String endpoint;

	private String accessKey;

	private String secretKey;

	private String defaultBucket;
}
