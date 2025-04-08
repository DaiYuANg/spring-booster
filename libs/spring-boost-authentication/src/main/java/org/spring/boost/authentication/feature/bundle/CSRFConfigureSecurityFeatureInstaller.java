/* (C)2024*/
package org.spring.boost.authentication.feature.bundle;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import org.spring.boost.authentication.feature.SecurityFeatureInstaller;
import org.spring.boost.authentication.properties.CSRFConfigurationProperties;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;

@RequiredArgsConstructor
public class CSRFConfigureSecurityFeatureInstaller implements SecurityFeatureInstaller {
  private final CSRFConfigurationProperties csrfConfigurationProperties;

  @SneakyThrows
  @Override
  public void install(@NotNull HttpSecurity http) {
//    TODO 封装 csrf 相关
    http.csrf(AbstractHttpConfigurer::disable);
  }
}
