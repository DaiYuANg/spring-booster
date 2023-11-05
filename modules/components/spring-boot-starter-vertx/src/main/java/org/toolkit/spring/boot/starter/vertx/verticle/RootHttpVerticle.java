package org.toolkit.spring.boot.starter.vertx.verticle;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.http.HttpServer;
import io.vertx.ext.web.Router;
import jakarta.annotation.Resource;
import lombok.val;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;
import org.toolkit.spring.boot.starter.vertx.configuration.properties.HttpConfigurationProperties;

import java.util.Optional;

@Component
@ConditionalOnProperty(name = "vertx.http.enable", havingValue = "true")
public class RootHttpVerticle extends AbstractVerticle {

    private Optional<HttpServer> httpServer;

    @Resource
    private HttpConfigurationProperties httpConfigurationProperties;

    @Resource
    private Router rootRouter;

    @Override
    public void start() {
        val server = vertx.createHttpServer();
        server.requestHandler(rootRouter);
        server.listen(httpConfigurationProperties.getPort());
    }

    @Override
    public void stop() {
        httpServer.ifPresent(HttpServer::close);
    }
}
