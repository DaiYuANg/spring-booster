package org.toolkit.spring.boot.starter.vertx.configuration;

import io.vertx.core.Vertx;
import io.vertx.core.VertxOptions;
import io.vertx.core.spi.cluster.ClusterManager;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.jetbrains.annotations.NotNull;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.toolkit.spring.boot.starter.vertx.configuration.properties.VertxConfigurationProperties;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@AutoConfiguration
@Slf4j
@EnableConfigurationProperties(VertxConfigurationProperties.class)
public class VertxAutoConfiguration {

    @Resource
    private Optional<ClusterManager> clusterManager;

    @Bean
    public Vertx vertx() {
        return clusterManager.map(cm -> clusterVertx(cm).join()).orElseGet(Vertx::vertx);
    }

    @NotNull
    private static CompletableFuture<Vertx> clusterVertx(ClusterManager cm) {
        val vertxFuture = new CompletableFuture<Vertx>();
        Vertx.clusteredVertx(new VertxOptions().setClusterManager(cm), result -> {
            if (result.succeeded()) {
                vertxFuture.complete(result.result());
            } else {
                vertxFuture.completeExceptionally(result.cause());
            }
        });
        return vertxFuture;
    }

    private @NotNull VertxOptions vertxOptions(){
        return new VertxOptions();
    }
}
