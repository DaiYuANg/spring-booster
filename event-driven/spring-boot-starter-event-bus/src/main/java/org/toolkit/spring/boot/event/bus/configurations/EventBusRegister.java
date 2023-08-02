package org.toolkit.spring.boot.event.bus.configurations;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Context;
import io.vertx.core.Vertx;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.toolkit.spring.boot.event.bus.annotations.Subscribe;
import org.toolkit.spring.boot.event.bus.annotations.Subscriber;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

@Component
@Slf4j
public class EventBusRegister {

    @Resource
    private ApplicationContext context;

    @Resource
    private Vertx vertx;

    @PostConstruct
    public void init() {
        val subscribers = context.getBeansWithAnnotation(Subscriber.class)
                .values().stream()
                .filter(r -> Arrays.stream(r.getClass().getMethods())
                        .anyMatch(method -> method.isAnnotationPresent(Subscribe.class)))
                .toList();

        subscribers.forEach(r -> Arrays.stream(r.getClass().getMethods())
                .filter(method -> method.isAnnotationPresent(Subscribe.class))
                .forEach(method ->
                        vertx.deployVerticle(new AbstractVerticle() {
                            @Override
                            public void init(Vertx vertx, Context context) {
                                super.init(vertx, context);
                                val sub = method.getAnnotation(Subscribe.class);
                                vertx.eventBus().consumer(sub.address(), event -> {

                                    try {
                                        method.invoke(r,event);
                                    } catch (IllegalAccessException | InvocationTargetException e) {
                                        throw new RuntimeException(e);
                                    }
                                });
                            }
                        })));
//        subscribers.forEach(s -> {
//            vertx.deployVerticle(new AbstractVerticle() {
//                @Override
//                public void init(Vertx vertx, Context context) {
////					vertx.eventBus().consumer()
//                    super.init(vertx, context);
//                }
//            });
//
//        });
    }
}
