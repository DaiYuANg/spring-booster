package org.toolkit.spring.boot.tika.configuration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@AutoConfiguration
@Slf4j
@EnableConfigurationProperties(TikaConfigurationProperties.class)
public class TikaAutoConfiguration {}
