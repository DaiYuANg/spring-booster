package org.toolkit.spring.boot.event.bus;

import io.vertx.core.eventbus.EventBus;
import io.vertx.core.eventbus.Message;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

@Component
public class Bus {

    @Resource
    private EventBus eventBus;

    public <T> void publish(String address, Message<T> carryData){
    }
}