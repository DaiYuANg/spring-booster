/* (C)2023*/
package org.toolkit.spring.boot.dotenv.autoconfigure;

import io.github.cdimascio.dotenv.Dotenv;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@AutoConfiguration
@Slf4j
@EnableConfigurationProperties(DotenvConfigurationProperties.class)
public class DotenvAutoConfiguration {

    @PostConstruct
    public void init() {
        log.info("dotenv auto configuration");
    }

    @Bean
    public Dotenv dotenv() {
        return Dotenv.configure().ignoreIfMalformed().load();
    }
}
