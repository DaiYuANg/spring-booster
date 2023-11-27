package org.toolkit.spring.boot.mapping.web.autoconfigure;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@AutoConfiguration
@Slf4j
@EnableConfigurationProperties(MappingWebConfigurationProperties.class)
public class MappingWebAutoConfiguration {

}
