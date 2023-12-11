package org.toolkit.spring.boot.vertx.event.bus.configuration;

import io.vertx.core.Vertx;
import io.vertx.core.eventbus.EventBus;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.toolkit.spring.boot.vertx.configuration.VertxAutoConfiguration;

@AutoConfiguration
@Slf4j
@EnableConfigurationProperties(EventBusConfigurationProperties.class)
@AutoConfigureAfter(VertxAutoConfiguration.class)
public class EventBusAutoConfiguration {

	@Resource
	private Vertx vertx;

	@Bean
	public EventBus eventBus() {
		log.info("register event bus");
		return vertx.eventBus();
	}
}
