/* (C)2023*/
package org.toolkit.spring.boot.mapping.source.code.configuration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.toolkit.spring.boot.mapping.source.code.processor.DataBeanProcessor;

@AutoConfiguration
@Slf4j
@EnableConfigurationProperties(MappingCodeSourceConfigurationProperties.class)
@ComponentScan("org.toolkit.spring.boot.mapping.source.code.**.*")
public class MappingCodeSourceAutoConfiguration {
    @Bean
    public DataBeanProcessor beanProcessor() {
        return new DataBeanProcessor();
    }
}
