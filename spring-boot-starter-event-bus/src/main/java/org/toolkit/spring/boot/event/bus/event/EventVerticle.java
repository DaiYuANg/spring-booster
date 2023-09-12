package org.toolkit.spring.boot.event.bus.event;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.eventbus.Message;
import java.lang.reflect.Method;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.toolkit.spring.boot.event.bus.annotations.Subscribe;

@Slf4j
public class EventVerticle extends AbstractVerticle {
	private final String address;

	private final Method method;

	private final Object o;

	public EventVerticle(Object o, String address, Method method) {
		this.o = o;
		this.address = address;
		this.method = method;
	}

	@Override
	public void start() throws Exception {
		val sub = method.getAnnotation(Subscribe.class);
		vertx.eventBus().consumer(sub.address(), this::handle);
	}

	@SneakyThrows
	private void handle(Message<Object> event) {
		method.invoke(o, event, context);
	}
}
