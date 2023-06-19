package org.kop.framework.spring.starter.dev.service.bootstrap;

import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class Startup {
    @EventListener(ApplicationStartedEvent.class)
    @Async
    public void init(){
        System.err.println("startUp");
    }
}
