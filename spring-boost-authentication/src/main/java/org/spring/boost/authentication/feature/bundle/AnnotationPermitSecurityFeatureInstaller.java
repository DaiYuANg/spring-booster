/* (C)2024*/
package org.spring.boost.authentication.feature.bundle;

import jakarta.annotation.security.PermitAll;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.jetbrains.annotations.NotNull;
import org.spring.boost.authentication.annotation.IgnoreAuthentication;
import org.spring.boost.authentication.feature.SecurityFeatureInstaller;
import org.spring.boost.core.api.BeanRegistry;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AuthorizeHttpRequestsConfigurer;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

@RequiredArgsConstructor
@Slf4j
@Order(0)
public class AnnotationPermitSecurityFeatureInstaller implements SecurityFeatureInstaller {
    private final BeanRegistry beanRegistry;

    @SneakyThrows
    @Override
    public void install(@NotNull HttpSecurity http) {
        val fromAnnotation = buildAntPathRequestMatcherFromAnnotation();
        http.authorizeHttpRequests(req -> {
            fromAnnotation.stream()
                    .map(req::requestMatchers)
                    .forEach(AuthorizeHttpRequestsConfigurer.AuthorizedUrl::permitAll);
            req.anyRequest().authenticated();
        });
    }

    private @NotNull List<AntPathRequestMatcher> buildAntPathRequestMatcherFromAnnotation() {
        return beanRegistry.getBeanDistinct(RequestMappingHandlerMapping.class).stream()
                .map(RequestMappingHandlerMapping::getHandlerMethods)
                .flatMap(method -> method.entrySet().stream())
                .filter(this::checkHasAnnotation)
                .flatMap(this::internalBuild)
                .toList();
    }

    private boolean checkHasAnnotation(Map.@NotNull Entry<RequestMappingInfo, HandlerMethod> method) {
        return method.getValue().hasMethodAnnotation(IgnoreAuthentication.class)
                || method.getValue().hasMethodAnnotation(PermitAll.class);
    }

    @NotNull private Stream<AntPathRequestMatcher> internalBuild(Map.@NotNull Entry<RequestMappingInfo, HandlerMethod> entry) {
        return entry.getKey().getDirectPaths().stream()
                .filter(path -> !path.isBlank())
                .flatMap(path -> buildAntPathByAnnotation(entry, path));
    }

    @NotNull private Stream<AntPathRequestMatcher> buildAntPathByAnnotation(
            Map.@NotNull Entry<RequestMappingInfo, HandlerMethod> entry, String path) {
        val ann = entry.getValue().getMethodAnnotation(IgnoreAuthentication.class);
        return Optional.ofNullable(ann)
                .map(ignore -> Arrays.stream(ignore.ignoreOnMethod())
                        .distinct()
                        .map(a ->
                                new AntPathRequestMatcher(path, a.asHttpMethod().name())))
                .orElseGet(() -> entry.getValue().hasMethodAnnotation(PermitAll.class)
                        ? Arrays.stream(new AntPathRequestMatcher[] {new AntPathRequestMatcher(path)})
                                .distinct()
                        : Arrays.stream(new AntPathRequestMatcher[0]).distinct());
    }
}
