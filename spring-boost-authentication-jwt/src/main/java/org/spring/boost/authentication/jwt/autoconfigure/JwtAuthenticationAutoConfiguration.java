/* (C)2024*/
package org.spring.boost.authentication.jwt.autoconfigure;

import lombok.extern.slf4j.Slf4j;
import org.spring.boost.authentication.jwt.filter.JwtAuthenticationFilter;
import org.spring.boost.authentication.jwt.service.IJwtService;
import org.spring.boost.authentication.jwt.service.impl.JwtServiceImpl;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetailsService;

@AutoConfiguration
@Slf4j
@EnableConfigurationProperties(JwtConfigProperties.class)
public class JwtAuthenticationAutoConfiguration {

    @Bean
    public IJwtService jwtService(JwtConfigProperties jwtConfigProperties) {
        return new JwtServiceImpl(jwtConfigProperties);
    }

    @Bean
    public JwtAuthenticationFilter jwtAuthenticationFilter(
            IJwtService jwtService, ApplicationEventPublisher eventPublisher, UserDetailsService userDetailsService) {
        return JwtAuthenticationFilter.builder()
                .jwtService(jwtService)
                .eventPublisher(eventPublisher)
                .userDetailsService(userDetailsService)
                .build();
    }
}