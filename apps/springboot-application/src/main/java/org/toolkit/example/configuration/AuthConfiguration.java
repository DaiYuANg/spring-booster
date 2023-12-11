package org.toolkit.example.configuration;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.actuate.web.exchanges.InMemoryHttpExchangeRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.toolkit.example.repository.ExampleUserEntityRepository;

@Configuration
@Slf4j
public class AuthConfiguration {

	@Resource
	private ExampleUserEntityRepository exampleUserEntityRepository;

	@Bean
	public UserDetailsService userDetailsService() {
		return username -> exampleUserEntityRepository
				.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("User not found"));
	}

	@Bean
	public AuditorAware<String> auditorAware() {
		return new ApplicationAuditAware();
	}

	@Bean
	public InMemoryHttpExchangeRepository createTraceRepository() {
		return new InMemoryHttpExchangeRepository();
	}
}
