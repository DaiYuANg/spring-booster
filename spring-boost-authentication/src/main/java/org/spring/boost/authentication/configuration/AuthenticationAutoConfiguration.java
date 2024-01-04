/* (C)2023*/
package org.spring.boost.authentication.configuration;

import jakarta.servlet.Filter;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.spring.boost.authentication.annotation.AuthenticationAfterFilter;
import org.spring.boost.authentication.annotation.AuthenticationAtFilter;
import org.spring.boost.authentication.annotation.AuthenticationBeforeFilter;
import org.spring.boost.authentication.annotation.AuthenticationFilter;
import org.spring.boost.authentication.configuration.properties.AuthenticationConfigurationProperties;
import org.spring.boost.authentication.configuration.properties.JwtConfigProperties;
import org.spring.boost.authentication.filter.JwtAuthenticationFilter;
import org.spring.boost.common.api.BeanRegistry;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.autoconfigure.task.TaskExecutionAutoConfiguration;
import org.springframework.boot.autoconfigure.validation.ValidationAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.DispatcherServletAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.*;
import org.springframework.core.Ordered;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.AuthorizeHttpRequestsConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@AutoConfiguration
@AutoConfigureOrder(Ordered.HIGHEST_PRECEDENCE)
@AutoConfigureAfter({
	DispatcherServletAutoConfiguration.class,
	TaskExecutionAutoConfiguration.class,
	ValidationAutoConfiguration.class
})
@EnableWebSecurity
@EnableConfigurationProperties({AuthenticationConfigurationProperties.class, JwtConfigProperties.class})
@Slf4j
@ComponentScan("org.toolkit.spring.boot.authentication.**.*")
@RequiredArgsConstructor
public class AuthenticationAutoConfiguration implements WebSecurityCustomizer {

	private final AuthenticationConfigurationProperties authenticationConfigurationProperties;

	private final AuthenticationProvider authenticationProvider;

	private final JwtAuthenticationFilter jwtAuthenticationFilter;

	private final Set<AntPathRequestMatcher> PermitAllRequestMather;

	private final BeanRegistry beanRegistry;

	@Bean
	public SecurityFilterChain securityFilterChain(
			@NotNull HttpSecurity http, AuthenticationManager authenticationManager) throws Exception {
		beanRegistry
				.getBeanWithAnnotationMap(AuthenticationAfterFilter.class, Filter.class)
				.forEach((a, f) -> http.addFilterAfter(f, a.value()));
		beanRegistry
				.getBeanWithAnnotationMap(AuthenticationBeforeFilter.class, Filter.class)
				.forEach((a, f) -> http.addFilterBefore(f, a.value()));
		beanRegistry
				.getBeanWithAnnotationMap(AuthenticationFilter.class, Filter.class)
				.forEach((a, f) -> http.addFilter(f));
		beanRegistry
				.getBeanWithAnnotationMap(AuthenticationAtFilter.class, Filter.class)
				.forEach((a, f) -> http.addFilterAt(f, a.value()));
		http.cors(AbstractHttpConfigurer::disable);
		http.csrf(AbstractHttpConfigurer::disable);
		http.authorizeHttpRequests(req -> {
			PermitAllRequestMather.stream()
					.map(req::requestMatchers)
					.forEach(AuthorizeHttpRequestsConfigurer.AuthorizedUrl::permitAll);
			req.anyRequest().authenticated();
		});
		http.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
		http.authenticationManager(authenticationManager);
		http.authenticationProvider(authenticationProvider);
		http.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
		log.info("build SecurityFilterChain");
		return http.build();
	}

	@Override
	public void customize(@NotNull WebSecurity web) {
		web.debug(authenticationConfigurationProperties.getDebug());
	}
}
