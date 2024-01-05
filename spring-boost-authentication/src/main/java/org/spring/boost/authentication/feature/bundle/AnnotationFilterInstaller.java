package org.spring.boost.authentication.feature.bundle;

import jakarta.servlet.Filter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.spring.boost.authentication.annotation.AuthenticationAfterFilter;
import org.spring.boost.authentication.annotation.AuthenticationAtFilter;
import org.spring.boost.authentication.annotation.AuthenticationBeforeFilter;
import org.spring.boost.authentication.annotation.AuthenticationFilter;
import org.spring.boost.authentication.feature.FeatureInstaller;
import org.spring.boost.common.api.BeanRegistry;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

@RequiredArgsConstructor
@Slf4j
public class AnnotationFilterInstaller implements FeatureInstaller {
    private final BeanRegistry beanRegistry;

    @Override
    public void install(HttpSecurity http) {
        beanRegistry
                .getBeanWithAnnotationMap(AuthenticationAfterFilter.class, Filter.class)
                .forEach((a, f) -> http.addFilterAfter(f, a.value()));
        beanRegistry
                .getBeanWithAnnotationMap(AuthenticationBeforeFilter.class, Filter.class)
                .forEach((a, f) -> http.addFilterBefore(f, a.value()));
        beanRegistry
                .getBeanWithAnnotationMap(AuthenticationFilter.class, Filter.class)
                .forEach((a, f) -> http.addFilter(f));
        beanRegistry
                .getBeanWithAnnotationMap(AuthenticationAtFilter.class, Filter.class)
                .forEach((a, f) -> http.addFilterAt(f, a.value()));
    }
}
