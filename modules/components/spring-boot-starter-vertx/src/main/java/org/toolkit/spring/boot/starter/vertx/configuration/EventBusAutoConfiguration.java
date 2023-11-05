package org.toolkit.spring.boot.starter.vertx.configuration;

import io.vertx.core.Vertx;
import io.vertx.core.eventbus.EventBus;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.toolkit.spring.boot.starter.vertx.configuration.properties.EventBusConfigurationProperties;

@AutoConfiguration
@Slf4j
@EnableConfigurationProperties(EventBusConfigurationProperties.class)
public class EventBusAutoConfiguration {

    @Resource
    private Vertx vertx;

    @Bean
    public EventBus eventBus(){
        return vertx.eventBus();
    }
}
