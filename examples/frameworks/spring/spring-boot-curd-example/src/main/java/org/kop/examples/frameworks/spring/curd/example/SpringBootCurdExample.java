package org.kop.examples.frameworks.spring.curd.example;

import org.jetbrains.annotations.NotNull;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class SpringBootCurdExample extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(@NotNull SpringApplicationBuilder builder) {
        return builder.sources(SpringBootCurdExample.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootCurdExample.class, args);
    }
}