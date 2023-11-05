package org.toolkit.spring.boot.starter.vertx.configuration.builder;

import io.vertx.core.VertxOptions;
import io.vertx.core.eventbus.EventBusOptions;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.toolkit.spring.boot.starter.vertx.configuration.properties.VertxConfigurationProperties;

@AutoConfiguration
@Slf4j
public class VertxConfigBuilder {

    @Resource
    private VertxConfigurationProperties vertxConfigurationProperties;

    public VertxOptions vertxOptions(){

        return new VertxOptions();
    }


}
