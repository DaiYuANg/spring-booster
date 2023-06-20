package org.kop.framework.spring.starter.dev.service.config.ui;

import org.kop.framework.spring.starter.dev.service.ui.IndexController;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ConditionalOnWebApplication
@EnableWebMvc
public class DevUIAutoConfiguration {
    @Bean
    public IndexController indexController() {
        return new IndexController();
    }
}
