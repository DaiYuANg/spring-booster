package org.kop.framework.spring.starter.authentication.configurations;

import jakarta.annotation.PostConstruct;
import org.kop.framework.spring.starter.authentication.funcational.JwtSigner;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@AutoConfiguration
@EnableConfigurationProperties(AuthenticationProperties.class)
@ComponentScan("org.kop.framework.spring.starter.authentication.services.**")
@EnableJpaRepositories("org.kop.framework.spring.starter.authentication.repos")
@EntityScan({"org.kop.framework.spring.starter.authentication.entities", "org.kop.standard.rbac"})
public class AuthenticationConfiguration {

    @PostConstruct
    public void init() {
    }

    @Bean
    public JwtSigner signer(){
        return new JwtSigner();
    }
}
