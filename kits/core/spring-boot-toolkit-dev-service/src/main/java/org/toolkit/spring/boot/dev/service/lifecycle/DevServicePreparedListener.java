package org.toolkit.spring.boot.dev.service.lifecycle;

import java.util.Set;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationShutdownHandlers;
import org.springframework.boot.context.event.ApplicationPreparedEvent;
import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.toolkit.spring.boot.dev.service.config.DevServiceConfigurationProperties;

@Slf4j
public class DevServicePreparedListener implements ApplicationListener<ApplicationPreparedEvent> {

	private final SpringApplicationShutdownHandlers shutdownHandlers;

	public DevServicePreparedListener() {
		this(SpringApplication.getShutdownHandlers());
	}

	DevServicePreparedListener(SpringApplicationShutdownHandlers shutdownHandlers) {
		this.shutdownHandlers = shutdownHandlers;
	}

	@Override
	public void onApplicationEvent(@NotNull ApplicationPreparedEvent event) {
		ConfigurableApplicationContext applicationContext = event.getApplicationContext();
		Binder binder = Binder.get(applicationContext.getEnvironment());
		DevServiceConfigurationProperties properties = DevServiceConfigurationProperties.get(binder);
		Set<ApplicationListener<?>> eventListeners =
				event.getSpringApplication().getListeners();
		//        DevServiceLifecycle.builder()
		//                .binder(binder)
		//                .build();
	}
}
