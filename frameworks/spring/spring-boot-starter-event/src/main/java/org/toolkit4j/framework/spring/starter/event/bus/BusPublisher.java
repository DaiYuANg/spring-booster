package org.toolkit4j.framework.spring.starter.event.bus;

import com.google.common.eventbus.EventBus;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

@Component
public class BusPublisher {

    @Resource
    private EventBus eventBus;

    public void publish(Object ev) {
        eventBus.post(ev);
    }
}
