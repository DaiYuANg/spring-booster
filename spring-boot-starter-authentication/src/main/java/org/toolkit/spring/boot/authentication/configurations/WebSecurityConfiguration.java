package org.toolkit.spring.boot.authentication.configurations;

import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

// @EnableWebSecurity
// @EnableWebSocketSecurity
@Slf4j
@Configuration
public class WebSecurityConfiguration {

	// @SneakyThrows
	// @Bean
	// public SecurityFilterChain configure(@NotNull HttpSecurity http) {
	// return http.csrf(AbstractHttpConfigurer::disable)
	// .authorizeHttpRequests(req -> req.requestMatchers("/**").permitAll())
	// .build();
	// }
	@Bean
	public WebSecurityCustomizer webSecurityCustomizer() {
		return (web) -> web.ignoring().requestMatchers(ignorePaths());
	}

	@Contract(" -> new")
	private AntPathRequestMatcher @NotNull [] ignorePaths() {
		return new AntPathRequestMatcher[] {
			new AntPathRequestMatcher("/dev/admin/system/**"),
		};
	}
}
