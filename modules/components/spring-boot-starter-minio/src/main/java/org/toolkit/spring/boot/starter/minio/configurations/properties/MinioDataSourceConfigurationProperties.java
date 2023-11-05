package org.toolkit.spring.boot.starter.minio.configurations.properties;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "toolkit.minio.datasource")
public class MinioDataSourceConfigurationProperties extends DataSourceProperties {
}
