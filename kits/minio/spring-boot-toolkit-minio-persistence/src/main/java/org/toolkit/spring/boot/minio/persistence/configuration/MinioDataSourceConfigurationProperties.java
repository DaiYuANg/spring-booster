package org.toolkit.spring.boot.minio.persistence.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.toolkit.spring.boot.starter.utils.struct.EnabledConfigurationProperties;

@ConfigurationProperties(prefix = "toolkit.minio.datasource")
@Getter
@Setter
public class MinioDataSourceConfigurationProperties extends EnabledConfigurationProperties {}
