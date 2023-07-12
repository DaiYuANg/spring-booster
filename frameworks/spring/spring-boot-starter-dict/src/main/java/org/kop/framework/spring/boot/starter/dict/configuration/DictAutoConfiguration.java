package org.kop.framework.spring.boot.starter.dict.configuration;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.google.gson.Gson;
import jakarta.annotation.Resource;
import org.kop.framework.spring.boot.starter.dict.scanner.DefaultDictScannerImpl;
import org.kop.framework.spring.boot.starter.dict.scanner.DictScanner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Optional;

@Configuration
@ComponentScan("org.kop.framework.spring.boot.starter.dict.**.*")
@EnableJpaRepositories("org.kop.framework.spring.boot.starter.dict.repos")
@EntityScan({"org.kop.framework.spring.boot.starter.dict"})
@EnableConfigurationProperties(DictConfigurationProperties.class)
public class DictAutoConfiguration {
    @Resource
    private DictConfigurationProperties dictConfigurationProperties;

    @Resource
    ConfigurableApplicationContext context;

    @Bean
    @ConditionalOnMissingBean(value = {Caffeine.class})
    public Cache<String, Optional<String>> cache() {
        return Caffeine.newBuilder().build();
    }

    @Bean
    @ConditionalOnMissingBean(value = {Gson.class})
    public Gson gson() {
        return new Gson();
    }

    @Bean
    public DictScanner dictScanner() {
        return new DefaultDictScannerImpl();
    }
}
