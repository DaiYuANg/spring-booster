package org.toolkit.spring.boot.starter.event.configurations;

import lombok.Data;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "event")
@Data
@ToString
public class EventConfigurationProperties {
	boolean enableEventBus = true;

	boolean asyncEventBus = false;

	private String[] eventBusName;
}
