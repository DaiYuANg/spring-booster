package org.toolkit.spring.boot.authentication.configuration;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.toolkit.spring.boot.authentication.configuration.properties.AuthenticationConfigurationProperties;
import org.toolkit.spring.boot.authentication.configuration.properties.JwtConfigProperties;

@AutoConfiguration
@EnableWebSecurity
@EnableConfigurationProperties({AuthenticationConfigurationProperties.class, JwtConfigProperties.class})
@Slf4j
public class AuthenticationAutoConfiguration {

	@SneakyThrows
	@Bean
	public SecurityFilterChain securityFilterChain(@NotNull HttpSecurity http) {
		//        http.authorizeHttpRequests(request -> {
		//                    request.requestMatchers(allIgnoreAuth())
		//                            .permitAll();
		//                    request.anyRequest().permitAll();
		//                }
		//        );
		return http.build();
	}
}
