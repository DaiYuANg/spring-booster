package org.toolkit.spring.boot.website.configuration;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.toolkit.spring.boot.website.interceptor.LanguageInterceptor;

@Configuration
@Slf4j
public class WebMvcConfiguration implements WebMvcConfigurer {
	@Resource
	private LanguageInterceptor languageInterceptor;

	@Override
	public void addResourceHandlers(@NotNull ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/**")
				.addResourceLocations("classpath:/static/")
				.setCachePeriod(-1);
	}

	@Override
	public void addInterceptors(@NotNull InterceptorRegistry registry) {
		registry.addInterceptor(languageInterceptor);
	}
}
