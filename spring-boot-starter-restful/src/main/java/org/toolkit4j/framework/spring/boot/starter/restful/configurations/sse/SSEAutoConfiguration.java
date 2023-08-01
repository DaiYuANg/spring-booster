package org.toolkit4j.framework.spring.boot.starter.restful.configurations.sse;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@AutoConfiguration
@Slf4j
@EnableConfigurationProperties(SSEConfigurationProperties.class)
public class SSEAutoConfiguration {}
