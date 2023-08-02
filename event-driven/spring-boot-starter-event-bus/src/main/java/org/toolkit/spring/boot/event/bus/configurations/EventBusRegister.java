package org.toolkit.spring.boot.event.bus.configurations;

import io.vertx.core.eventbus.EventBus;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.toolkit.spring.boot.event.bus.annotations.Subscriber;

@Component
@Slf4j
public class EventBusRegister {

    @Resource
    private ApplicationContext context;

    @Resource
    private EventBus eventBus;

    @PostConstruct
    public void init(){
        val subscribers = context.getBeansWithAnnotation(Subscriber.class);
    }
}
