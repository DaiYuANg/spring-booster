package org.kop.framework.spring.starter.dev.service.bootstrap;

import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class Startup implements ApplicationListener<ContextRefreshedEvent> {
    @Override
    public void onApplicationEvent(@NotNull ContextRefreshedEvent event) {
        log.info("context refresh");
    }
}
