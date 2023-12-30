/* (C)2023*/
package org.toolkit.spring.boot.vertx.event.bus;

import io.vertx.core.eventbus.Message;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.toolkit.spring.boot.vertx.event.bus.annotation.EventConsumer;
import org.toolkit.spring.boot.vertx.event.bus.base.EventBusHandler;

@EventConsumer("test")
@Slf4j
public class Consumer implements EventBusHandler<String> {

	@Override
	public void handle(@NotNull Message<String> event) {
		log.info("event:{}", event);
		System.err.println(event.body());
	}
}
