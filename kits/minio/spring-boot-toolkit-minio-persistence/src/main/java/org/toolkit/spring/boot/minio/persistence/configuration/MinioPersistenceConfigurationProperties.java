package org.toolkit.spring.boot.minio.persistence.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "toolkit.minio.persistence")
public class MinioPersistenceConfigurationProperties {

	private String tablePrefix;
}
