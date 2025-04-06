package org.spring.boost.authentication.feature.bundle;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.jetbrains.annotations.NotNull;
import org.spring.boost.authentication.SecurityFeatureInstaller;
import org.springdoc.core.properties.SwaggerUiConfigProperties;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

@RequiredArgsConstructor
@Slf4j
@Order(1)
public class SwaggerUISupportFeatureInstaller implements SecurityFeatureInstaller {
  private final SwaggerUiConfigProperties swaggerUiConfigProperties;

  private final ObjectMapper objectMapper;

  @SneakyThrows
  @Override
  public void install(@NotNull HttpSecurity httpSecurity) {
    val config = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(swaggerUiConfigProperties);
    log.atDebug().log("swagger Ui:{}", config);
    httpSecurity.authorizeHttpRequests(req -> {
      req.requestMatchers("/swagger-ui/**")
        .permitAll()
        .requestMatchers("/v3/api-docs*/**")
        .permitAll();
    });
  }
}
