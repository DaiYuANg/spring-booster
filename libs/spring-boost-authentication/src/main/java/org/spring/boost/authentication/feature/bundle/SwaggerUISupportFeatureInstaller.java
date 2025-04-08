package org.spring.boost.authentication.feature.bundle;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.jetbrains.annotations.NotNull;
import org.spring.boost.authentication.feature.AuthorizeHttpRequestFeatureInstaller;
import org.spring.boost.authentication.feature.SecurityFeatureInstaller;
import org.springdoc.core.properties.SwaggerUiConfigProperties;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AuthorizeHttpRequestsConfigurer;

@RequiredArgsConstructor
@Slf4j
@Order(1)
public class SwaggerUISupportFeatureInstaller implements AuthorizeHttpRequestFeatureInstaller {
  private final SwaggerUiConfigProperties swaggerUiConfigProperties;

  @Override
  public void install(AuthorizeHttpRequestsConfigurer<HttpSecurity>.@NotNull AuthorizationManagerRequestMatcherRegistry authorizationManagerRequestMatcherRegistry) {
    log.atTrace().log("Configured Swagger UI paths to be permitted");
    authorizationManagerRequestMatcherRegistry
      .requestMatchers("/swagger-ui/**")
      .permitAll()
      .requestMatchers("/swagger-ui.html")
      .permitAll()
      .requestMatchers("/v3/api-docs*/**")
      .permitAll();
  }
}
