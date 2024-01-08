/* (C)2023*/
package org.spring.boost.dev.service.lifecycle;

import java.util.Set;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.jetbrains.annotations.NotNull;
import org.spring.boost.dev.service.config.DevServiceConfigurationProperties;
import org.springframework.boot.SpringApplicationShutdownHandlers;
import org.springframework.boot.context.event.ApplicationPreparedEvent;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;

@Slf4j
@EnableConfigurationProperties(DevServiceConfigurationProperties.class)
public class DevServicePreparedListener implements ApplicationListener<ApplicationPreparedEvent> {

    private final SpringApplicationShutdownHandlers shutdownHandlers;

    DevServicePreparedListener(SpringApplicationShutdownHandlers shutdownHandlers) {
        this.shutdownHandlers = shutdownHandlers;
    }

    @Override
    public void onApplicationEvent(@NotNull ApplicationPreparedEvent event) {
        log.atInfo().log("Dev service active");
        ConfigurableApplicationContext applicationContext = event.getApplicationContext();
        Binder binder = Binder.get(applicationContext.getEnvironment());

        Set<ApplicationListener<?>> eventListeners =
                event.getSpringApplication().getListeners();
        val lifecycle = new DevServiceLifecycle(applicationContext, binder, eventListeners);
        lifecycle.start();
    }
}
