package org.toolkit.spring.boot.starter.minio.configurations;

import java.util.concurrent.TimeUnit;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;
import org.toolkit.spring.boot.starter.minio.functional.CredentialsCentre;

@ConfigurationProperties(prefix = "io.minio", ignoreInvalidFields = true)
@ToString
@Getter
@Setter
public class MinioConfigurationProperties {
	private String accessPrefix = "/minio";

	private long credentialExpire = 1;

	private TimeUnit credentialUnit = TimeUnit.MINUTES;

	private String endpoint;

	private String accessKey;

	private String secretKey;

	private String defaultBucket;
	//	@NestedConfigurationProperty
	//	private MinioConfig minioConfig;

	//	@NestedConfigurationProperty
	//	private Map<String, MinioConfig> minioInstances = new HashMap<>();

	@NestedConfigurationProperty
	private CredentialsCentre credentialsCentre;

	private String instancePublicAccessUrl;
}
