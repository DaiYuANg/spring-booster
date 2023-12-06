package org.toolkit.spring.boot.supervisor.autoconfigure;

import io.javalin.Javalin;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@AutoConfiguration
@Slf4j
@ComponentScan("org.toolkit.spring.boot.supervisor.**.*")
public class SupervisorAutoConfiguration {

    @Bean
    public Javalin javalin() {
        return Javalin.create();
    }
}
