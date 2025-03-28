package org.spring.boost.authentication.feature.bundle;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import org.spring.boost.authentication.SecurityFeatureInstaller;
import org.springdoc.core.properties.SwaggerUiConfigProperties;
import org.springdoc.webmvc.ui.SwaggerConfig;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

@RequiredArgsConstructor
public class SwaggerUISupportFeatureInstaller implements SecurityFeatureInstaller {
  private final SwaggerUiConfigProperties swaggerUiConfigProperties;

  @SneakyThrows
  @Override
  public void install(@NotNull HttpSecurity httpSecurity) {
    httpSecurity.authorizeHttpRequests(req->{
      req.requestMatchers(swaggerUiConfigProperties.getUrl()).permitAll();
    });
  }
}
