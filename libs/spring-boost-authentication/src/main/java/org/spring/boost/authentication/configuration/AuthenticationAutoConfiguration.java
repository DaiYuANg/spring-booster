/* (C)2023*/
package org.spring.boost.authentication.configuration;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.jetbrains.annotations.NotNull;
import org.spring.boost.authentication.feature.AuthorizeHttpRequestFeatureInstaller;
import org.spring.boost.authentication.feature.SecurityFeatureInstaller;
import org.spring.boost.authentication.properties.AuthenticationConfigurationProperties;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.task.TaskExecutionAutoConfiguration;
import org.springframework.boot.autoconfigure.validation.ValidationAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.DispatcherServletAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.AuthorizeHttpRequestsConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import java.util.Set;

@AutoConfiguration
@AutoConfigureOrder(Ordered.HIGHEST_PRECEDENCE)
@AutoConfigureAfter({
  DispatcherServletAutoConfiguration.class,
  TaskExecutionAutoConfiguration.class,
  ValidationAutoConfiguration.class
})
@AutoConfigurationPackage
@EnableWebSecurity
@EnableConfigurationProperties({AuthenticationConfigurationProperties.class})
@Slf4j
@RequiredArgsConstructor
@EnableMethodSecurity
public class AuthenticationAutoConfiguration implements WebSecurityCustomizer {

  private final AuthenticationConfigurationProperties authenticationConfigurationProperties;

  @Bean
  public DaoAuthenticationProvider daoAuthenticationProvider(PasswordEncoder passwordEncoder, UserDetailsService userDetailsService) {
    DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
    daoAuthenticationProvider.setPasswordEncoder(passwordEncoder);
    daoAuthenticationProvider.setUserDetailsService(userDetailsService);
    return daoAuthenticationProvider;
  }

  @Bean
  public AuthenticationManager authenticationManager(@NotNull AuthenticationConfiguration config) throws Exception {
    return config.getAuthenticationManager();
  }

  @Bean
  @ConditionalOnBean(UserDetailsService.class)
  public AuthenticationProvider authenticationProvider(
    PasswordEncoder passwordEncoder, UserDetailsService userDetailsService
  ) {
    val authProvider = new DaoAuthenticationProvider();
    authProvider.setUserDetailsService(userDetailsService);
    authProvider.setPasswordEncoder(passwordEncoder);
    return authProvider;
  }

  @Bean
  @ConditionalOnBean(UserDetailsService.class)
  public SecurityFilterChain securityFilterChain(
    @NotNull HttpSecurity http,
    AuthenticationManager authenticationManager,
    @NotNull Set<SecurityFeatureInstaller> securityFeatureInstallers,
    AuthenticationProvider authenticationProvider,
    Set<AuthorizeHttpRequestFeatureInstaller> authorizeHttpRequestFeatureInstallers
  )
    throws Exception {
    securityFeatureInstallers
      .stream()
      .peek(installer -> log.atDebug().log("Install feature:{}", installer))
      .forEach(it -> it.install(http));
    http.formLogin(AbstractHttpConfigurer::disable);
    http.securityMatcher(authenticationConfigurationProperties.getAuthenticateAt());
    http.authenticationManager(authenticationManager);
    http.authenticationProvider(authenticationProvider);
    http.authorizeHttpRequests(req -> {
      log.atInfo().log("Authorizing requests");
      authorizeHttpRequestFeatureInstallers
        .forEach(installer -> installer.install(req));
      req.anyRequest().authenticated();
    });
    return http.build();
  }

  @Override
  public void customize(@NotNull WebSecurity web) {
    web.debug(authenticationConfigurationProperties.getDebug());
  }
}
