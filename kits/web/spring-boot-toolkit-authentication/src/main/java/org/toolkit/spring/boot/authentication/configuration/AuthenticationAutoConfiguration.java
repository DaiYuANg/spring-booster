package org.toolkit.spring.boot.authentication.configuration;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.boot.actuate.autoconfigure.security.servlet.EndpointRequest;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.*;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;
import org.toolkit.spring.boot.authentication.configuration.properties.AuthenticationConfigurationProperties;
import org.toolkit.spring.boot.authentication.configuration.properties.JwtConfigProperties;
import org.toolkit.spring.boot.authentication.filter.JwtAuthenticationFilter;
import org.toolkit.spring.boot.authentication.service.IJwtService;

@AutoConfiguration
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

    @Resource
    private AuthenticationProvider authenticationProvider;

    @Resource
    @Lazy
    private JwtAuthenticationFilter jwtAuthenticationFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(@NotNull HttpSecurity http, MvcRequestMatcher.Builder mvc)
            throws Exception {
        http.cors(AbstractHttpConfigurer::disable);
        http.csrf(AbstractHttpConfigurer::disable);
        http.authorizeHttpRequests(req -> req
                .requestMatchers("/example/login")
                .permitAll()
                .anyRequest().authenticated()
        );
        http.httpBasic(AbstractHttpConfigurer::disable);
        http.securityMatcher(EndpointRequest.toAnyEndpoint());
        http.logout(AbstractHttpConfigurer::disable);
        http.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        http.authenticationManager(authenticationManager);
        http.authenticationProvider(authenticationProvider);
        http.addFilterBefore(jwtAuthenticationFilter,UsernamePasswordAuthenticationFilter.class);
        log.info("build SecurityFilterChain");
        return http.build();
    }

    @Scope("prototype")
    @Bean
    MvcRequestMatcher.Builder mvc(HandlerMappingIntrospector introspector) {
        return new MvcRequestMatcher.Builder(introspector);
    }

    @Override
    public void customize(@NotNull WebSecurity web) {
        web.debug(authenticationConfigurationProperties.isDebug());
    }
}
