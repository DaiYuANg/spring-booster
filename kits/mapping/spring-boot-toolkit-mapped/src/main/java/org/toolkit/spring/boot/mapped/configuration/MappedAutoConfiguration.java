package org.toolkit.spring.boot.mapped.configuration;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@AutoConfiguration
@EnableConfigurationProperties(MappedConfigurationProperties.class)
public class MappedAutoConfiguration {}
