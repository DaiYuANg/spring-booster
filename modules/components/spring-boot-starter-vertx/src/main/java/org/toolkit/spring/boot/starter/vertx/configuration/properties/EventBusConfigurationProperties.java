package org.toolkit.spring.boot.starter.vertx.configuration.properties;

import io.vertx.core.eventbus.EventBus;
import io.vertx.core.eventbus.EventBusOptions;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.toolkit.spring.boot.starter.vertx.base.BaseConfigurationProperties;

@ConfigurationProperties(prefix = "toolkit.vertx.event-bus")
@Setter
@Getter
@ToString
public class EventBusConfigurationProperties extends BaseConfigurationProperties {

    private Integer acceptBacklog;

    private String host;

    private boolean logActivity;
}
