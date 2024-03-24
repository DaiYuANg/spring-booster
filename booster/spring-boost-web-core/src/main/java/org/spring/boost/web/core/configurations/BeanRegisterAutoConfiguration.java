/* (C)2024*/
package org.spring.boost.web.core.configurations;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import nl.basjes.parse.useragent.UserAgentAnalyzer;
import org.spring.boost.core.api.BeanRegistry;
import org.spring.boost.web.core.feature.InterceptorsFeatureInstaller;
import org.spring.boost.web.core.filter.ReusableRequestFilter;
import org.spring.boost.web.core.resolver.IndexHtmlResolver;
import org.spring.boost.web.core.resolver.UserAgentResolver;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.CommonsRequestLoggingFilter;

@AutoConfiguration
@Slf4j
@RequiredArgsConstructor
public class BeanRegisterAutoConfiguration {

  private final BeanRegistry beanRegistry;

  @Bean
  InterceptorsFeatureInstaller interceptorsFeatureInstaller() {
    return new InterceptorsFeatureInstaller(beanRegistry);
  }

  @Bean
  IndexHtmlResolver indexHtmlResolver() {
    return new IndexHtmlResolver();
  }

  @Bean
  CommonsRequestLoggingFilter requestLoggingFilter() {
    val loggingFilter = new CommonsRequestLoggingFilter();
    loggingFilter.setIncludeClientInfo(true);
    loggingFilter.setIncludeQueryString(true);
    loggingFilter.setIncludePayload(true);
    loggingFilter.setIncludeHeaders(true);
    return loggingFilter;
  }

  @Bean
  @ConditionalOnProperty(
      name = "enable-reusable-request",
      prefix = "spring.boost.web",
      havingValue = "true")
  FilterRegistrationBean<ReusableRequestFilter> filterRegistrationBean() {
    FilterRegistrationBean<ReusableRequestFilter> registration = new FilterRegistrationBean<>();
    registration.setFilter(new ReusableRequestFilter());
    registration.addUrlPatterns("/*");
    registration.setName("repeatableFilter");
    registration.setOrder(FilterRegistrationBean.LOWEST_PRECEDENCE);
    return registration;
  }

  @Bean
  UserAgentAnalyzer userAgentAnalyzer() {
    val builder = UserAgentAnalyzer.newBuilder().hideMatcherLoadStats().withCache(10000);
    return builder.build();
  }

  @Bean
  UserAgentResolver userAgentResolver(UserAgentAnalyzer userAgentAnalyzer) {
    return new UserAgentResolver(userAgentAnalyzer);
  }
}
