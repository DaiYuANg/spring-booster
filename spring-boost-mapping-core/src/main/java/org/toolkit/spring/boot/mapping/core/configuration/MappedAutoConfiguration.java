/* (C)2023*/
package org.toolkit.spring.boot.mapping.core.configuration;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.toolkit.spring.boot.scanner.autoconfigure.ScannerAutoConfiguration;

@AutoConfiguration
@EnableConfigurationProperties(MappedConfigurationProperties.class)
@ComponentScan("org.toolkit.spring.boot.mapping.core.**.*")
@AutoConfigureAfter(ScannerAutoConfiguration.class)
public class MappedAutoConfiguration {}
