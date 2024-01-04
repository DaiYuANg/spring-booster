/* (C)2024*/
package org.spring.boost.authentication.configuration;

import lombok.extern.slf4j.Slf4j;
import org.spring.boost.authentication.filter.JwtAuthenticationFilter;
import org.spring.boost.authentication.service.IJwtService;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetailsService;

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
