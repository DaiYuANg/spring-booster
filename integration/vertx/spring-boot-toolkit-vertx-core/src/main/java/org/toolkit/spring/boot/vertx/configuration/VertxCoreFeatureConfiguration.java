package org.toolkit.spring.boot.vertx.configuration;

import io.vertx.core.Vertx;
import io.vertx.core.file.FileSystem;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;

@AutoConfiguration
@Slf4j
public class VertxCoreFeatureConfiguration {

    @Resource
    private Vertx vertx;

    @Bean
    public FileSystem fileSystem(){
        return vertx.fileSystem();
    }

}
