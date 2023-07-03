package org.kop.framework.spring.boot.starter.groundwork.dict.configuration;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.google.gson.Gson;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Optional;

@AutoConfiguration
@ComponentScan("org.kop.framework.spring.boot.starter.groundwork.dict.**.*")
@EnableJpaRepositories("org.kop.framework.spring.boot.starter.groundwork.dict.repos")
@EntityScan({"org.kop.framework.spring.boot.starter.groundwork.dict.entities"})
@EnableConfigurationProperties(DictConfigurationProperties.class)
public class DictAutoConfiguration {
    @Resource
    private DictConfigurationProperties dictConfigurationProperties;

    @PostConstruct
    public void init() {

    }

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
}
