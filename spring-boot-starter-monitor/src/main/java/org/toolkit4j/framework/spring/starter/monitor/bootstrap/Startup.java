package org.toolkit4j.framework.spring.starter.monitor.bootstrap;

import jakarta.annotation.Resource;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.toolkit4j.framework.spring.starter.monitor.configurations.endpoint.ServerBasicInfo;

@Component
@Slf4j
public class Startup {

	@Resource
	private ServerBasicInfo serverBasicInfo;

	@Resource
	ConfigurableApplicationContext context;

	@SneakyThrows
	@EventListener(ApplicationReadyEvent.class)
	public void onStarted(@NotNull ApplicationReadyEvent event) {
		log.info(
				"Application:{}",
				event.getSpringApplication().getMainApplicationClass().getName());
		log.info("Access at: {}", serverBasicInfo.fullAccessPath());
		log.info("Swagger at: {}", serverBasicInfo.swaggerUI());
	}
}
