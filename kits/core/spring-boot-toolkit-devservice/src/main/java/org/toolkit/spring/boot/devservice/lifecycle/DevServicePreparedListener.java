package org.toolkit.spring.boot.devservice.lifecycle;

import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationShutdownHandlers;
import org.springframework.boot.context.event.ApplicationPreparedEvent;
import org.springframework.context.ApplicationListener;

@Slf4j
public class DevServicePreparedListener implements ApplicationListener<ApplicationPreparedEvent> {

    private final SpringApplicationShutdownHandlers shutdownHandlers;
    public DevServicePreparedListener(){
        this(SpringApplication.getShutdownHandlers());
//        log.info("application prepared");
    }

    DevServicePreparedListener(SpringApplicationShutdownHandlers shutdownHandlers) {
        this.shutdownHandlers = shutdownHandlers;
        log.info("application prepared");
    }

    @Override
    public void onApplicationEvent(@NotNull ApplicationPreparedEvent event) {
//        event.
        log.info("application prepared");
    }
}
