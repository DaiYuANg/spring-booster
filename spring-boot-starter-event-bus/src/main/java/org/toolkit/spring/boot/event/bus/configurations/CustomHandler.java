package org.toolkit.spring.boot.event.bus.configurations;

import io.vertx.core.Handler;
import io.vertx.core.eventbus.Message;
import org.jetbrains.annotations.NotNull;
import org.springframework.context.event.EventListener;
import org.toolkit.spring.boot.event.bus.annotations.Subscriber;

@Subscriber(address = "test")
public class CustomHandler implements Handler<Message<String>> {
    @Override
    @EventListener
    public void handle(@NotNull Message<String> event) {
        event.reply("dsadsa");
        System.err.println(event.body());
    }
}
