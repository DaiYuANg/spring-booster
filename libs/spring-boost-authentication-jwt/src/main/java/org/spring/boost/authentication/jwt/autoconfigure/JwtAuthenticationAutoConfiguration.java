/* (C)2024*/
package org.spring.boost.authentication.jwt.autoconfigure;

import lombok.extern.slf4j.Slf4j;
import org.spring.boost.authentication.jwt.JwtSecurityFeatureInstaller;
import org.spring.boost.authentication.jwt.filter.JwtAuthenticationFilter;
import org.spring.boost.authentication.jwt.service.JwtService;
import org.spring.boost.authentication.jwt.service.impl.JwtServiceImpl;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetailsService;

@AutoConfiguration
@Slf4j
@EnableConfigurationProperties(JwtConfigProperties.class)
public class JwtAuthenticationAutoConfiguration {

  @Bean
  public JwtService jwtService(JwtConfigProperties jwtConfigProperties) {
    return new JwtServiceImpl(jwtConfigProperties);
  }

  @Bean
  public JwtAuthenticationFilter jwtAuthenticationFilter(
    JwtService jwtService, ApplicationEventPublisher eventPublisher, UserDetailsService userDetailsService) {
    return JwtAuthenticationFilter.builder()
      .jwtService(jwtService)
      .eventPublisher(eventPublisher)
      .userDetailsService(userDetailsService)
      .build();
  }

  @Bean
  JwtSecurityFeatureInstaller jwtSecurityFeatureInstaller(JwtAuthenticationFilter jwtAuthenticationFilter){
    return new JwtSecurityFeatureInstaller(jwtAuthenticationFilter);
  }
}
