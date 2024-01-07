/* (C)2023*/
package org.spring.boost.authentication.configuration;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.jetbrains.annotations.NotNull;
import org.spring.boost.authentication.feature.SecurityFeatureInstaller;
import org.spring.boost.authentication.properties.AuthenticationConfigurationProperties;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
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
@EnableWebSecurity
@EnableConfigurationProperties({AuthenticationConfigurationProperties.class})
@Slf4j
@RequiredArgsConstructor
@EnableMethodSecurity
public class AuthenticationAutoConfiguration implements WebSecurityCustomizer {

    private final AuthenticationConfigurationProperties authenticationConfigurationProperties;

    @Bean
    public AuthenticationManager authenticationManager(@NotNull AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    @Bean
    public AuthenticationProvider authenticationProvider(
            PasswordEncoder passwordEncoder, UserDetailsService userDetailsService) {
        val authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder);
        return authProvider;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(
            @NotNull HttpSecurity http,
            AuthenticationManager authenticationManager,
            @NotNull Set<SecurityFeatureInstaller> securityFeatureInstallers,
            AuthenticationProvider authenticationProvider)
            throws Exception {
        securityFeatureInstallers.parallelStream().forEachOrdered(it -> {
            it.install(http);
            log.atTrace().log("Install feature:{}", it);
        });
        http.securityMatcher(authenticationConfigurationProperties.getAuthenticateAt());
        http.authorizeHttpRequests(req -> req.anyRequest().authenticated());
        http.authenticationManager(authenticationManager);
        http.authenticationProvider(authenticationProvider);
        return http.build();
    }

    @Override
    public void customize(@NotNull WebSecurity web) {
        web.debug(authenticationConfigurationProperties.getDebug());
    }
}
