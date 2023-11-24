package org.toolkit.spring.boot.authentication.configuration;

import jakarta.annotation.Resource;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.toolkit.spring.boot.authentication.filter.JwtAuthenticationFilter;
import org.toolkit.spring.boot.authentication.service.IJwtService;

@AutoConfiguration
public class RegisterFilter {
    @Resource
    @Lazy
    private IJwtService jwtService;

    @Resource
    @Lazy
    private UserDetailsService userDetailsService;

    @Bean
    public JwtAuthenticationFilter jwtAuthenticationFilter() {
        return new JwtAuthenticationFilter(jwtService,userDetailsService);
    }
}
