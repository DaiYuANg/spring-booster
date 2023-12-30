/* (C)2023*/
package org.toolkit.spring.boot.web.core.configurations;

import cn.hutool.extra.spring.EnableSpringUtil;
import io.reactivex.rxjava3.core.Flowable;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import java.util.Arrays;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.jetbrains.annotations.NotNull;
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
@EnableSpringUtil
@ComponentScan("org.toolkit.spring.boot.web.core.**.*")
public class WebCoreAutoConfiguration implements WebMvcConfigurer {

	@Resource
	private ApplicationContext context;

	@PostConstruct
	public void init() {
		log.info("Restful auto config ");
	}

	@Override
	public void extendMessageConverters(@NotNull List<HttpMessageConverter<?>> converters) {
		converters.removeIf(httpMessageConverter -> httpMessageConverter instanceof StringHttpMessageConverter);
	}

	@Override
	public void addInterceptors(@NotNull InterceptorRegistry registry) {
		var unused = Flowable.fromIterable(
						context.getBeansWithAnnotation(Interceptor.class).values())
				.filter(interceptor -> interceptor instanceof HandlerInterceptor)
				.map(interceptor -> (HandlerInterceptor) interceptor)
				.subscribe(interceptor -> {
					val ann = interceptor.getClass().getAnnotation(Interceptor.class);
					val path = Arrays.stream(ann.value()).toList();
					val exclude = Arrays.stream(ann.excludePath()).toList();

					registry.addInterceptor(interceptor)
							.order(ann.order())
							.excludePathPatterns(exclude)
							.addPathPatterns(path);
				});
	}

	@Override
	public void addArgumentResolvers(@NotNull List<HandlerMethodArgumentResolver> resolvers) {
		resolvers.add(new UserAgentResolver());
	}

	@Bean
	public CommonsRequestLoggingFilter requestLoggingFilter() {
		CommonsRequestLoggingFilter loggingFilter = new CommonsRequestLoggingFilter();
		loggingFilter.setIncludeClientInfo(true);
		loggingFilter.setIncludeQueryString(true);
		loggingFilter.setIncludePayload(true);
		loggingFilter.setIncludeHeaders(true);
		return loggingFilter;
	}
}
