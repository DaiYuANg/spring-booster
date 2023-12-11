package org.toolkit.spring.boot.vertx.event.bus.configuration;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.toolkit.spring.boot.vertx.configuration.properties.BaseConfigurationProperties;

@ConfigurationProperties(prefix = "toolkit.vertx.event-bus")
@Setter
@Getter
@ToString
public class EventBusConfigurationProperties extends BaseConfigurationProperties {

	private Integer acceptBacklog;

	private String host;

	private boolean logActivity;
}
