/* (C)2023*/
package org.spring.boost.authentication.configuration;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.spring.boost.authentication.configuration.properties.JwtConfigProperties;
import org.spring.boost.authentication.service.IJwtService;
import org.spring.boost.authentication.service.impl.JwtServiceImpl;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

@AutoConfiguration
@Slf4j
@RequiredArgsConstructor
public class RegisterBeanAutoConfiguration {

	private final JwtConfigProperties jwtConfigProperties;

	private final UserDetailsService userDetailsService;

	private final PasswordEncoder passwordEncoder;

	@Bean
	public AuthenticationManager authenticationManager(@NotNull AuthenticationConfiguration config) throws Exception {
		return config.getAuthenticationManager();
	}

	@Bean
	@ConditionalOnMissingBean(IJwtService.class)
	public IJwtService jwtService() {
		return new JwtServiceImpl(jwtConfigProperties);
	}

	@Bean
	public AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(userDetailsService);
		authProvider.setPasswordEncoder(passwordEncoder);
		return authProvider;
	}
}
