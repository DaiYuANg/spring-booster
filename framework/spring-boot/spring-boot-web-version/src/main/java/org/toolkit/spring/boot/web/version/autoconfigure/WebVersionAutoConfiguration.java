package org.toolkit.spring.boot.web.version.autoconfigure;

import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import org.toolkit.spring.boot.web.version.mapping.VersionRequestMapping;

@AutoConfiguration
@Slf4j
@EnableConfigurationProperties(WebVersionConfigurationProperties.class)
public class WebVersionAutoConfiguration extends WebMvcConfigurationSupport {
	@Override
	public @NotNull RequestMappingHandlerMapping createRequestMappingHandlerMapping() {
		return new VersionRequestMapping();
	}
}
