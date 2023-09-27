package org.toolkit.spring.boot.starter.minio.configurations;

import java.util.concurrent.TimeUnit;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "toolkit.minio", ignoreInvalidFields = true)
@ToString
@Getter
@Setter
public class MinioConfigurationProperties {
	private String previewPattern = "/minio/preview/**";

	private long credentialExpire = 1;

	private TimeUnit credentialUnit = TimeUnit.MINUTES;

	private String endpoint;

	private String accessKey;

	private String secretKey;

	private String defaultBucket;

	private String instancePublicAccessUrl;
}
