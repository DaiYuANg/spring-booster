/* (C)2023*/
package org.toolkit.spring.boot.mapping.web.autoconfigure;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.bytebuddy.ByteBuddy;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.toolkit.spring.boot.mapping.web.aop.MappedResponseHandler;

@AutoConfiguration
@Slf4j
@Configuration(proxyBeanMethods=false)
@EnableConfigurationProperties(MappingWebConfigurationProperties.class)
@RequiredArgsConstructor
public class MappingWebAutoConfiguration {

    private final MappingWebConfigurationProperties properties;

    @Bean
    ByteBuddy byteBuddy() {
        return new ByteBuddy();
    }

    @Bean
    MappedResponseHandler mappedResponseHandler(ByteBuddy byteBuddy) {
        return new MappedResponseHandler(byteBuddy);
    }
}
