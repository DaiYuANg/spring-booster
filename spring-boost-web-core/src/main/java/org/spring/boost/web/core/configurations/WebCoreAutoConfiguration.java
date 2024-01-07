/* (C)2023*/
package org.spring.boost.web.core.configurations;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.spring.boost.web.core.feature.InterceptorsFeatureInstaller;
import org.spring.boost.web.core.resolver.IndexHtmlResolver;
import org.spring.boost.web.core.resolver.UserAgentResolver;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@AutoConfiguration
@Slf4j
@EnableConfigurationProperties(WebCoreConfigurationProperties.class)
@RequiredArgsConstructor
public class WebCoreAutoConfiguration implements WebMvcConfigurer {

    private final InterceptorsFeatureInstaller interceptorsFeatureInstaller;

    private final IndexHtmlResolver indexHtmlResolver;

    private final UserAgentResolver userAgentResolver;

    private final ObjectMapper objectMapper;

    @Override
    public void addInterceptors(@NotNull InterceptorRegistry registry) {
        interceptorsFeatureInstaller.install(registry);
    }

    @Override
    public void addArgumentResolvers(@NotNull List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(userAgentResolver);
    }

    @Override
    public void configureMessageConverters(@NotNull List<HttpMessageConverter<?>> converters) {
        MappingJackson2HttpMessageConverter jackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter(objectMapper);
        converters.add(jackson2HttpMessageConverter);
    }

    @Override
    public void addResourceHandlers(@NotNull ResourceHandlerRegistry registry) {
        registry.addResourceHandler().resourceChain(true).addResolver(indexHtmlResolver);
    }
}
