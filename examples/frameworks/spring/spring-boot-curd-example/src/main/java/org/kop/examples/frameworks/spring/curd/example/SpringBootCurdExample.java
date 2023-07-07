package org.kop.examples.frameworks.spring.curd.example;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.jetbrains.annotations.NotNull;
import org.kop.framework.spring.boot.starter.groundwork.dict.annotation.EnableGroundworkDict;
import org.kop.framework.spring.boot.starter.groundwork.tag.annotation.EnableGroundworkTag;
import org.kop.framework.spring.starter.dev.admin.annotations.EnableDevAdmin;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.metrics.buffering.BufferingApplicationStartup;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@EnableGroundworkDict
@EnableGroundworkTag
@EnableDevAdmin
@Slf4j
public class SpringBootCurdExample extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(@NotNull SpringApplicationBuilder builder) {
        return builder.sources(SpringBootCurdExample.class);
    }

    @SneakyThrows
    public static void main(String[] args) {
        val app = new SpringApplication(SpringBootCurdExample.class);
        app.setApplicationStartup(new BufferingApplicationStartup(2048));
        ConfigurableApplicationContext a = app.run(args);
    }
}