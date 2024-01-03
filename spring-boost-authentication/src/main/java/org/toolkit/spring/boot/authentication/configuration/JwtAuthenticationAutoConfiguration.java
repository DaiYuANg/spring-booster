/* (C)2024*/
package org.toolkit.spring.boot.authentication.configuration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.toolkit.spring.boot.authentication.filter.JwtAuthenticationFilter;
import org.toolkit.spring.boot.authentication.service.IJwtService;

@AutoConfiguration
@Slf4j
public class JwtAuthenticationAutoConfiguration {

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
