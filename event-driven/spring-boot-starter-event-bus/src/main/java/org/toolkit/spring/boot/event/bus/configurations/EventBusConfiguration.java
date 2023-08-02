package org.toolkit.spring.boot.event.bus.configurations;

import io.vertx.core.Vertx;
import io.vertx.core.eventbus.EventBus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@AutoConfiguration
@EnableConfigurationProperties(EventBusConfigurationProperties.class)
@Slf4j
public class EventBusConfiguration {

    @Bean
    public Vertx vertx() {
        return Vertx.vertx();
    }

    @Bean
    public EventBus eventBus() {
        return vertx().eventBus();
    }
}
