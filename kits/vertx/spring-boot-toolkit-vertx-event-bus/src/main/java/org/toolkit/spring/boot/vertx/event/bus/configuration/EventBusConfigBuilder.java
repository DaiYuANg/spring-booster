package org.toolkit.spring.boot.vertx.event.bus.configuration;

import io.vertx.core.eventbus.EventBusOptions;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;

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
