package org.kop.framework.spring.starter.dev.service.bootstrap;

import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.metrics.ApplicationStartup;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class Startup {
    @EventListener(ContextRefreshedEvent.class)
    public void onRefresh(@NotNull ContextRefreshedEvent event) {
        log.info("context refresh");
    }

    @EventListener(ApplicationStartup.class)
    public void onStarted(ApplicationStartup event) {
        log.info("application started");
    }
}
