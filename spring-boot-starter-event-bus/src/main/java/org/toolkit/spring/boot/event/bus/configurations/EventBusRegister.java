package org.toolkit.spring.boot.event.bus.configurations;

import io.vertx.core.Vertx;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import java.lang.reflect.Method;
import java.util.Arrays;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.jetbrains.annotations.NotNull;
import org.springframework.context.ApplicationContext;
import org.toolkit.spring.boot.event.bus.annotations.Subscribe;
import org.toolkit.spring.boot.event.bus.annotations.Subscriber;
import org.toolkit.spring.boot.event.bus.event.EventVerticle;

@Slf4j
public class EventBusRegister {

	@Resource
	private ApplicationContext context;

	@Resource
	private Vertx vertx;

	@PostConstruct
	public void init() {
		log.info("start register event bus subscriber");
		context.getBeansWithAnnotation(Subscriber.class).values().stream()
				.filter(r -> Arrays.stream(r.getClass().getMethods())
						.anyMatch(method -> method.isAnnotationPresent(Subscribe.class)))
				.forEach(this::registerEventSubscribeMethod);
		log.info("event bus registered");
		vertx.eventBus().request("application", "te");
	}

	private void registerEventSubscribeMethod(@NotNull Object r) {
		log.info("register subscriber:{}", r.getClass());
		Arrays.stream(r.getClass().getMethods())
				.filter(method -> method.isAnnotationPresent(Subscribe.class))
				.forEach(method -> deployVerticle(r, method));
	}

	private void deployVerticle(Object o, @NotNull Method method) {
		val sub = method.getAnnotation(Subscribe.class);
		vertx.deployVerticle(new EventVerticle(o, sub.address(), method));
	}
}
