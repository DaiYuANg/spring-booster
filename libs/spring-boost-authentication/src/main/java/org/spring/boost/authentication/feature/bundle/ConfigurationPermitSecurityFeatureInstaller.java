/* (C)2024*/
package org.spring.boost.authentication.feature.bundle;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.jetbrains.annotations.NotNull;
import org.spring.boost.authentication.constant.Method;
import org.spring.boost.authentication.feature.AuthorizeHttpRequestFeatureInstaller;
import org.spring.boost.authentication.properties.PermitConfigurationProperties;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AuthorizeHttpRequestsConfigurer;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Slf4j
@Order(0)
public class ConfigurationPermitSecurityFeatureInstaller implements AuthorizeHttpRequestFeatureInstaller {
  private final Set<PermitConfigurationProperties> properties;

  @Override
  public void install(AuthorizeHttpRequestsConfigurer<HttpSecurity>.@NotNull AuthorizationManagerRequestMatcherRegistry authorizationManagerRequestMatcherRegistry) {
    val fromConfiguration = buildAntPathRequestMatcherFromConfig();
    fromConfiguration.stream()
      .map(authorizationManagerRequestMatcherRegistry::requestMatchers)
      .forEach(AuthorizeHttpRequestsConfigurer.AuthorizedUrl::permitAll);
  }

  private List<AntPathRequestMatcher> buildAntPathRequestMatcherFromConfig() {
    val allMethod = Arrays.stream(Method.ALL_METHOD).collect(Collectors.toUnmodifiableSet());
    return properties.stream()
      .distinct()
      .peek(r -> {
        if (Objects.nonNull(r.getMethod())) return;
        r.setMethod(allMethod);
      })
      .flatMap(permit -> permit.getMethod().stream()
        .map(method -> new AntPathRequestMatcher(
          permit.getPattern(), method.asHttpMethod().name())))
      .toList();
  }
}
