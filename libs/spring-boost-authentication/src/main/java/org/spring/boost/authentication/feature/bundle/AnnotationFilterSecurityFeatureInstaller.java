/* (C)2024*/
package org.spring.boost.authentication.feature.bundle;

import jakarta.servlet.Filter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.spring.boost.authentication.SecurityFeatureInstaller;
import org.spring.boost.authentication.annotation.AuthenticationAfterFilter;
import org.spring.boost.authentication.annotation.AuthenticationAtFilter;
import org.spring.boost.authentication.annotation.AuthenticationBeforeFilter;
import org.spring.boost.authentication.annotation.AuthenticationFilter;
import org.spring.boost.core.api.BeanRegistry;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import java.lang.annotation.Annotation;
import java.util.function.BiConsumer;


@RequiredArgsConstructor
@Slf4j
public class AnnotationFilterSecurityFeatureInstaller implements SecurityFeatureInstaller {
  private final BeanRegistry beanRegistry;

  private <T extends Annotation> void addFilters(
    Class<T> annotationType, BiConsumer<? super T, ? super Filter> action) {
    beanRegistry.getBeanWithAnnotationMap(annotationType, Filter.class).forEach(action);
  }

  @Override
  public void install(HttpSecurity httpSecurity) {
    addFilters(AuthenticationAfterFilter.class, (a, f) -> httpSecurity.addFilterAfter(f, a.value()));
    addFilters(AuthenticationBeforeFilter.class, (a, f) -> httpSecurity.addFilterBefore(f, a.value()));
    addFilters(AuthenticationAtFilter.class, (a, f) -> httpSecurity.addFilterAt(f, a.value()));
    addFilters(AuthenticationFilter.class, (a, f) -> httpSecurity.addFilter(f));
  }
}
