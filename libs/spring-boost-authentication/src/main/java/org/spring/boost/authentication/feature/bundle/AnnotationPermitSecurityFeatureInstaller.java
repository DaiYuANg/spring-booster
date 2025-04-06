/* (C)2024 */
package org.spring.boost.authentication.feature.bundle;

import jakarta.annotation.security.PermitAll;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.spring.boost.authentication.SecurityFeatureInstaller;
import org.spring.boost.authentication.annotation.IgnoreAuthentication;
import org.spring.boost.core.api.BeanRegistry;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AuthorizeHttpRequestsConfigurer;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

@RequiredArgsConstructor
@Slf4j
@Order(0)
public class AnnotationPermitSecurityFeatureInstaller implements SecurityFeatureInstaller {
  private final BeanRegistry beanRegistry;

  @SneakyThrows
  @Override
  public void install(@NotNull HttpSecurity http) {
    // Build the list of AntPathRequestMatchers from annotations
    List<AntPathRequestMatcher> fromAnnotation = buildAntPathRequestMatcherFromAnnotation();

    // Logging the paths that are configured to allow access without authentication
    log.info("Configured paths to be permitted: {}", fromAnnotation);

    // Apply the security configurations
    http.authorizeHttpRequests(req -> {
      // Permit all for paths defined in annotations
      fromAnnotation.stream()
        .map(req::requestMatchers)
        .forEach(AuthorizeHttpRequestsConfigurer.AuthorizedUrl::permitAll);


    });
  }

  // Build a list of AntPathRequestMatchers from the annotations on handler methods
  private @NotNull List<AntPathRequestMatcher> buildAntPathRequestMatcherFromAnnotation() {
    // Getting handler methods from RequestMappingHandlerMapping
    return beanRegistry.getBeanDistinct(RequestMappingHandlerMapping.class).stream()
      .map(RequestMappingHandlerMapping::getHandlerMethods)
      .flatMap(method -> method.entrySet().stream())
      .filter(this::checkHasAnnotation) // Filter methods that have the relevant annotations
      .flatMap(this::buildAntPathForHandlerMethod) // Build the AntPathRequestMatchers
      .toList();
  }

  // Check if the method has the relevant annotations (PermitAll or IgnoreAuthentication)
  private boolean checkHasAnnotation(Map.@NotNull Entry<RequestMappingInfo, HandlerMethod> method) {
    // Log the methods being checked for annotations
    log.debug("Checking method: {}", method.getValue().getMethod().getName());

    return method.getValue().hasMethodAnnotation(IgnoreAuthentication.class)
      || method.getValue().hasMethodAnnotation(PermitAll.class);
  }

  // Build AntPathRequestMatchers based on the handler method's annotations
  @NotNull
  private Stream<AntPathRequestMatcher> buildAntPathForHandlerMethod(Map.@NotNull Entry<RequestMappingInfo, HandlerMethod> entry) {
    return entry.getKey().getDirectPaths().stream()
      .filter(path -> !path.isBlank()) // Filter out blank paths
      .flatMap(path -> buildAntPathByAnnotation(entry, path)); // Map paths to AntPathRequestMatchers
  }

  // Build AntPathRequestMatchers based on annotations
  @NotNull
  private Stream<AntPathRequestMatcher> buildAntPathByAnnotation(Map.@NotNull Entry<RequestMappingInfo, HandlerMethod> entry, String path) {
    // Check if the IgnoreAuthentication annotation is present
    return Optional.ofNullable(entry.getValue().getMethodAnnotation(IgnoreAuthentication.class))
      .map(ignore -> {
        // If IgnoreAuthentication annotation is present, apply the relevant HTTP methods
        log.info("Method {} is annotated with IgnoreAuthentication. Ignoring authentication for path: {}", entry.getValue().getMethod().getName(), path);
        return Arrays.stream(ignore.ignoreOnMethod())
          .distinct()
          .map(a -> new AntPathRequestMatcher(path, a.asHttpMethod().name()));
      })
      .orElseGet(() -> getAntPathRequestMatcherStream(entry, path)); // If no IgnoreAuthentication, check for PermitAll
  }

  // If the method has PermitAll annotation, permit all requests for that path
  private static @NotNull Stream<AntPathRequestMatcher> getAntPathRequestMatcherStream(Map.@NotNull Entry<RequestMappingInfo, HandlerMethod> entry, String path) {
    if (entry.getValue().hasMethodAnnotation(PermitAll.class)) {
      log.info("Method {} is annotated with PermitAll. Permitting all for path: {}", entry.getValue().getMethod().getName(), path);
      return Arrays.stream(new AntPathRequestMatcher[]{new AntPathRequestMatcher(path)})
        .distinct();
    }
    return Stream.empty();
  }
}
