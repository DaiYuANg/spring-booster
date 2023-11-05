package org.toolkit.spring.boot.starter.vertx.lifecycle;

import io.vertx.core.http.HttpMethod;
import io.vertx.ext.web.Route;
import io.vertx.ext.web.Router;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.jetbrains.annotations.NotNull;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.toolkit.spring.boot.starter.vertx.annotations.HttpHandler;
import org.toolkit.spring.boot.starter.vertx.base.HttpRouterHandler;

import java.util.Optional;
import java.util.logging.Handler;

@Component
@Slf4j
public class HttpHandlerRegister {
    @Resource
    private Router router;

    @Resource
    private ApplicationContext context;


    @PostConstruct
    public void init() {
        context.getBeansWithAnnotation(HttpHandler.class).values()
                .stream()
                .map(handler -> (HttpRouterHandler) handler)
                .forEach(this::attachRoute);
    }

    private void attachRoute(@NotNull HttpRouterHandler handler) {
        val ann = handler.getClass().getAnnotation(HttpHandler.class);
        var method = Optional.<HttpMethod>empty();
        switch (ann.method()) {
            case GET -> method = Optional.of(HttpMethod.GET);
            case POST -> method = Optional.of(HttpMethod.POST);
            case PUT -> method = Optional.of(HttpMethod.PUT);
            case OPTIONS -> method = Optional.of(HttpMethod.OPTIONS);
            case DELETE -> method = Optional.of(HttpMethod.DELETE);
            case PATCH -> method = Optional.of(HttpMethod.PATCH);
            case HEAD -> method = Optional.of(HttpMethod.HEAD);
        }
        val route = method.map(m -> router.route(m, ann.path()))
                .orElseGet(() -> router.route(ann.path()));
        route.handler(handler);
        log.atInfo().log("register method:{},on path:{}", route.methods(), route.getPath());
    }
}
