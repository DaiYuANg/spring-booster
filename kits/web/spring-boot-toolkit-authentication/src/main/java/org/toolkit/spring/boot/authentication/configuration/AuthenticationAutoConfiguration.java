package org.toolkit.spring.boot.authentication.configuration;

import jakarta.annotation.Resource;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
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
import org.toolkit.spring.boot.authentication.configuration.properties.AuthenticationConfigurationProperties;
import org.toolkit.spring.boot.authentication.configuration.properties.JwtConfigProperties;
import org.toolkit.spring.boot.authentication.filter.JwtAuthenticationFilter;

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
@EnableAspectJAutoProxy(proxyTargetClass = true)
@ComponentScan("org.toolkit.spring.boot.authentication.**.*")
public class AuthenticationAutoConfiguration implements WebSecurityCustomizer {

	@Resource
	private AuthenticationConfigurationProperties authenticationConfigurationProperties;

	@Resource
	@Lazy
	private AuthenticationManager authenticationManager;
	//
	@Resource
	private AuthenticationProvider authenticationProvider;
	//
	@Resource
	private JwtAuthenticationFilter jwtAuthenticationFilter;

	@Resource(name = "PermitAllRequestMather")
	private List<AntPathRequestMatcher> permitAll;

	@Bean
	public SecurityFilterChain securityFilterChain(@NotNull HttpSecurity http) throws Exception {
		http.cors(AbstractHttpConfigurer::disable);
		http.csrf(AbstractHttpConfigurer::disable);
		http.authorizeHttpRequests(req -> {
			permitAll.stream()
					.map(req::requestMatchers)
					.forEach(AuthorizeHttpRequestsConfigurer.AuthorizedUrl::permitAll);
			req.anyRequest().authenticated();
		});
		http.logout(AbstractHttpConfigurer::disable);
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
