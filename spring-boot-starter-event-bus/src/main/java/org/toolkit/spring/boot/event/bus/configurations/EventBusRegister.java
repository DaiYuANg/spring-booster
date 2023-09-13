package org.toolkit.spring.boot.event.bus.configurations;

import com.google.common.reflect.TypeToken;
import io.vertx.core.Handler;
import io.vertx.core.eventbus.EventBus;
import io.vertx.core.eventbus.Message;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;

import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.jetbrains.annotations.NotNull;
import org.springframework.context.ApplicationContext;
import org.toolkit.spring.boot.event.bus.annotations.Subscriber;

@Slf4j
public class EventBusRegister {

    @Resource
    private ApplicationContext context;

    @Resource
    private EventBus eventBus;

    @PostConstruct
    public void init() {
        context.getBeansWithAnnotation(Subscriber.class).values()
                .stream().filter(subscriber -> {
                    return subscriber instanceof Handler<?> && isHandlerForMessageType(subscriber);
                })
                .map(s -> (Handler<Message<?>>) s)
                .forEach(subscriber -> {
                    System.err.println(subscriber.getClass().getTypeName());
                    val sub = subscriber.getClass().getAnnotation(Subscriber.class);
                    eventBus.consumer(sub.address());
                });
    }

    private boolean isHandlerForMessageType(@NotNull Object subscriber) {
        Class<?> subscriberClass = subscriber.getClass();
        Type[] interfaces = subscriberClass.getGenericInterfaces();
        for (Type type : interfaces) {
            if (!(type instanceof ParameterizedType parameterizedType)) {
                continue;
            }
            Type[] typeArguments = parameterizedType.getActualTypeArguments();
//            if (typeArguments.length > 0 && typeArguments[0] == messageType) {
//                return true;
//            }
            for (Type typeArgument : typeArguments) {
                if (typeArgument instanceof Message<?>) {
                    return true;
                }
            }
        }

        return false;
    }

    private void registerEventSubscribeMethod(@NotNull Object r) {
//		log.info("register subscriber:{}", r.getClass());
//		Arrays.stream(r.getClass().getMethods())
//				.filter(method -> method.isAnnotationPresent(Subscribe.class))
//				.forEach(method -> deployVerticle(r, method));
    }

    private void deployVerticle(Object o, @NotNull Method method) {
//		val sub = method.getAnnotation(Subscribe.class);
//		vertx.deployVerticle(new EventVerticle(o, sub.address(), method));
    }
}
