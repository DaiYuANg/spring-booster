package org.toolkit.spring.boot.vertx.event.bus.configuration;

import io.vertx.core.Vertx;
import io.vertx.core.eventbus.EventBus;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

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
