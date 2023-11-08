package org.toolkit.spring.boot.vertx.lifecycle;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Vertx;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class VerticleRegister {

    @Resource
    private ApplicationContext context;

    @Resource
    private Vertx vertx;

    @PostConstruct
    public void init() {
        context.getBeansOfType(AbstractVerticle.class).values().forEach(vertx::deployVerticle);
    }
}
