package org.kop.framework.spring.starter.authentication.configurations;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.socket.EnableWebSocketSecurity;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@EnableWebSocketSecurity
@Slf4j
public class WebSecurityConfiguration {

    @SneakyThrows
    @Bean
    public SecurityFilterChain configure(@NotNull HttpSecurity http) {
        return http.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(req -> req.requestMatchers("/**").permitAll())
                .build();
    }
}
