package org.toolkit.spring.boot.starter.restful.configurations;

import cn.hutool.extra.spring.EnableSpringUtil;
import jakarta.annotation.PostConstruct;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.toolkit.spring.boot.starter.restful.interceptor.AllowClientInterceptor;

@AutoConfiguration
@Slf4j
@EnableConfigurationProperties(RestfulConfigurationProperties.class)
@EnableSpringUtil
@ComponentScan("org.toolkit.spring.boot.starter.restful.**.*")
public class RestfulAutoConfiguration implements WebMvcConfigurer {
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
		registry.addInterceptor(new AllowClientInterceptor());
	}
}
