package org.toolkit.spring.boot.authentication.configurations;

import jakarta.annotation.PostConstruct;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.toolkit.spring.boot.authentication.funcational.JwtSigner;

@AutoConfiguration
@EnableConfigurationProperties(AuthenticationProperties.class)
@ComponentScan("org.toolkit4J.framework.spring.starter.authentication.services.**")
@EnableJpaRepositories("org.toolkit4J.framework.spring.starter.authentication.repos")
@EntityScan({"org.toolkit4J.framework.spring.starter.authentication.entities", "org.toolkit4j.standard.rbac"})
public class AuthenticationConfiguration {

	@PostConstruct
	public void init() {}

	@Bean
	public JwtSigner signer() {
		return new JwtSigner();
	}
}
