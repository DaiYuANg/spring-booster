package org.toolkit.spring.boot.event.bus.configurations;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Vertx;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.jetbrains.annotations.NotNull;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.toolkit.spring.boot.event.bus.annotations.Subscribe;
import org.toolkit.spring.boot.event.bus.annotations.Subscriber;

@Component
@Slf4j
public class EventBusRegister {

	@Resource
	private ApplicationContext context;

	@Resource
	private Vertx vertx;

	@PostConstruct
	public void init() {
		context.getBeansWithAnnotation(Subscriber.class).values().stream()
				.filter(r -> Arrays.stream(r.getClass().getMethods())
						.anyMatch(method -> method.isAnnotationPresent(Subscribe.class)))
				.forEach(this::registerEventSubscribeMethod);
		log.info("event bus registered");
		vertx.eventBus().request("application", "te");
	}

	private void registerEventSubscribeMethod(@NotNull Object r) {
		Arrays.stream(r.getClass().getMethods()).forEach(method -> deployVerticle(r, method));
	}

	private void deployVerticle(Object o, Method method) {
		vertx.deployVerticle(new AbstractVerticle() {
			@Override
			public void start() {
				val sub = method.getAnnotation(Subscribe.class);
				vertx.eventBus().consumer(sub.address(), event -> {
					try {
						method.invoke(o, event, context);
					} catch (IllegalAccessException | InvocationTargetException e) {
						throw new RuntimeException(e);
					}
				});
			}
		});
	}
}
