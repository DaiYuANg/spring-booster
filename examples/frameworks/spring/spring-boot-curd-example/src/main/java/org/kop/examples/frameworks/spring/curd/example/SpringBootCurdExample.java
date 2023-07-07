package org.kop.examples.frameworks.spring.curd.example;

import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.jetbrains.annotations.NotNull;
import org.kop.framework.spring.boot.starter.groundwork.dict.annotation.EnableGroundworkDict;
import org.kop.framework.spring.boot.starter.groundwork.tag.annotation.EnableGroundworkTag;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.metrics.buffering.BufferingApplicationStartup;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
@EnableGroundworkDict
@EnableGroundworkTag
@Slf4j
public class SpringBootCurdExample extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(@NotNull SpringApplicationBuilder builder) {
        return builder.sources(SpringBootCurdExample.class);
    }

    public static void main(String[] args) {
        val app = new SpringApplication(SpringBootCurdExample.class);
        app.setApplicationStartup(new BufferingApplicationStartup(2048));
        app.run(args);
        log.info("Spring boot CURD Example Start up");
    }
}