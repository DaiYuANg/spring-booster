package org.toolkit.spring.boot.dev.service.autoconfigure;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.annotation.Order;

@AutoConfiguration
@Slf4j
@EnableConfigurationProperties(DevserviceConfigurationProperties.class)
@ComponentScan("org.toolkit.spring.boot.devservice.**.*")
@Order(0)
public class DevserviceAutoConfiguration {

}
