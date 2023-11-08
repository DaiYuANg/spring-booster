package org.toolkit.spring.boot.vertx.verticle;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.http.HttpServer;
import io.vertx.ext.web.Router;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;
import org.toolkit.spring.boot.vertx.configuration.properties.HttpConfigurationProperties;

import java.util.Optional;

@Component
@ConditionalOnProperty(name = "toolkit.vertx.http.enable", havingValue = "true")
@Slf4j
public class RootHttpVerticle extends AbstractVerticle {

    private Optional<HttpServer> httpServer;

    @Resource
    private HttpConfigurationProperties httpConfigurationProperties;

    @Resource
    private Router rootRouter;

    @PostConstruct
    public void init() {
        log.atInfo().log("root verticle executing");
    }

    @Override
    public void start() {
        val server = vertx.createHttpServer();
        server.requestHandler(rootRouter);
        server.listen(httpConfigurationProperties.getPort())
                .onSuccess(event -> log.atInfo().log("vertx http server listen:http://localhost:{}}", httpConfigurationProperties.getPort()))
                .onFailure(e -> log.atError().log(e.getMessage(), e ))
        ;
    }

    @Override
    public void stop() {
        httpServer.ifPresent(HttpServer::close);
    }
}
