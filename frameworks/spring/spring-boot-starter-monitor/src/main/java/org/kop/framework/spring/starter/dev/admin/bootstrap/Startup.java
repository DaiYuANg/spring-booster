package org.kop.framework.spring.starter.dev.admin.bootstrap;

import jakarta.annotation.Resource;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.kop.framework.spring.starter.dev.admin.configurations.endpoint.ServerBasicInfo;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.metrics.ApplicationStartup;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class Startup {

    @Resource
    private ServerBasicInfo serverBasicInfo;

    @EventListener(ContextRefreshedEvent.class)
    @Async
    public void onRefresh(@NotNull ContextRefreshedEvent event) {
        log.info("context refresh");
    }

    @EventListener(ApplicationStartup.class)
    @Async
    public void onStartup(ApplicationStartup event) {
        log.info("application startup");
    }

    @SneakyThrows
    @EventListener(ApplicationReadyEvent.class)
    @Async
    public void onStarted(@NotNull ApplicationReadyEvent event) {
        log.info("Application:{}",event.getSpringApplication().getMainApplicationClass().getName());
        log.info("Access at: {}",serverBasicInfo.fullAccessPath());
        log.info("Swagger at: {}",serverBasicInfo.swaggerUI());
    }
}
