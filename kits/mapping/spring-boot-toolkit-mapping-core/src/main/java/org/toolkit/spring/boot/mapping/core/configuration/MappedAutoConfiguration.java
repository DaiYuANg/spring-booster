package org.toolkit.spring.boot.mapping.core.configuration;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

@AutoConfiguration
@EnableConfigurationProperties(MappedConfigurationProperties.class)
@ComponentScan("org.toolkit.spring.boot.mapping.core.**.*")
public class MappedAutoConfiguration {}
