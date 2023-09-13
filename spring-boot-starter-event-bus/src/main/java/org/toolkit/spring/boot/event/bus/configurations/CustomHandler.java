package org.toolkit.spring.boot.event.bus.configurations;

import io.vertx.core.eventbus.Message;
import org.toolkit.spring.boot.event.bus.annotations.Subscriber;

@Subscriber(address = "test")
public class CustomHandler implements io.vertx.core.Handler<Message<String>> {
    @Override
    public void handle(Message<String> event) {
        System.err.println(event.body());
    }
}
