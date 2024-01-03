/* (C)2023*/
package org.toolkit.spring.boot.web.core.configurations;

import java.util.Arrays;
import java.util.List;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.jetbrains.annotations.NotNull;
import org.spring.boost.common.api.BeanRegistry;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.filter.CommonsRequestLoggingFilter;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.toolkit.spring.boot.web.annotation.Interceptor;
import org.toolkit.spring.boot.web.core.resolver.UserAgentResolver;

@AutoConfiguration
@Slf4j
@EnableConfigurationProperties(WebCoreConfigurationProperties.class)
@RequiredArgsConstructor
@ComponentScan("org.toolkit.spring.boot.web.core.**.*")
public class WebCoreAutoConfiguration implements WebMvcConfigurer {

    private final BeanRegistry beanRegistry;

    @Override
    public void extendMessageConverters(@NotNull List<HttpMessageConverter<?>> converters) {
        converters.removeIf(httpMessageConverter -> httpMessageConverter instanceof StringHttpMessageConverter);
    }

    @Override
    public void addInterceptors(@NotNull InterceptorRegistry registry) {
        beanRegistry.getBeanWithAnnotationMap(Interceptor.class, HandlerInterceptor.class)
                .forEach((a, i) -> {
                    val path = Arrays.stream(a.value()).toList();
                    val order = a.order();
                    val exclude = Arrays.stream(a.excludePath()).toList();
                    registry.addInterceptor(i).order(order)
                            .addPathPatterns(path)
                            .excludePathPatterns(exclude);
                });
    }

    @Override
    public void addArgumentResolvers(@NotNull List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(new UserAgentResolver());
    }

    @Bean
    public CommonsRequestLoggingFilter requestLoggingFilter() {
        val loggingFilter = new CommonsRequestLoggingFilter();
        loggingFilter.setIncludeClientInfo(true);
        loggingFilter.setIncludeQueryString(true);
        loggingFilter.setIncludePayload(true);
        loggingFilter.setIncludeHeaders(true);
        return loggingFilter;
    }
}
