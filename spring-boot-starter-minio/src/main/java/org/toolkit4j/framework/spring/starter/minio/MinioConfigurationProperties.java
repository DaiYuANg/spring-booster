package org.toolkit4j.framework.spring.starter.minio;

import cn.hutool.extra.spring.EnableSpringUtil;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

@ConfigurationProperties(prefix = "io.minio", ignoreInvalidFields = true)
@ToString
@Getter
@Setter
@EnableSpringUtil
public class MinioConfigurationProperties {
	private String accessPrefix = "minio";

	private long credentialExpire = 1;

	private TimeUnit credentialUnit = TimeUnit.MINUTES;

	@NestedConfigurationProperty
	Map<String, MinioConfig> minioInstances = new HashMap<>();

	private String instancePublicAccessUrl;
}
