package org.spring.boost.web.core.configurations;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.spring.boost.core.api.BeanRegistry;
import org.spring.boost.web.core.feature.InterceptorsFeatureInstaller;
import org.spring.boost.web.core.resolver.IndexHtmlResolver;
import org.spring.boost.web.core.resolver.UserAgentResolver;
import org.springframework.boot.actuate.web.exchanges.InMemoryHttpExchangeRepository;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.CommonsRequestLoggingFilter;
import ua_parser.Parser;

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
    Parser parser() {
        return new Parser(Parser.getDefaultLoaderOptions());
    }

    @Bean
    UserAgentResolver userAgentResolver(Parser parser) {
        return new UserAgentResolver(parser);
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
}
