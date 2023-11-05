package org.toolkit.spring.boot.starter.vertx.configuration.properties;

import io.vertx.core.eventbus.EventBusOptions;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "vertx.event-bus")
@Setter
@Getter
@ToString
public class EventBusConfigurationProperties extends EventBusOptions {

}
