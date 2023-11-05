package org.toolkit.spring.boot.starter.vertx.configuration.builder;

import io.vertx.core.eventbus.EventBusOptions;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.toolkit.spring.boot.starter.vertx.configuration.properties.EventBusConfigurationProperties;

@AutoConfiguration
@Slf4j
public class EventBusConfigBuilder {

    @Resource
    private EventBusConfigurationProperties eventBusConfigurationProperties;

    @Bean
    public EventBusOptions eventBusOptions() {
        val options = new EventBusOptions();
        return options;
    }
}
