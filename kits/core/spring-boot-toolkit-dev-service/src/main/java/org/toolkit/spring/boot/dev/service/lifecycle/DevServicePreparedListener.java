package org.toolkit.spring.boot.dev.service.lifecycle;

import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.jetbrains.annotations.NotNull;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationShutdownHandlers;
import org.springframework.boot.context.event.ApplicationPreparedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.util.ClassUtils;
import org.toolkit.spring.boot.dev.service.constant.DatabaseDriver;

import java.util.Arrays;

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
//        event.
        log.info("application prepared");
        val lifecycle = new DevServiceLifecycle();
        lifecycle.start();
    }
}
