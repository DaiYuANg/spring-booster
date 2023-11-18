package org.toolkit.spring.boot.authentication.configuration;

import cn.hutool.core.util.StrUtil;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import jakarta.annotation.security.PermitAll;
import java.util.*;
import java.util.stream.Stream;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.jetbrains.annotations.NotNull;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import org.toolkit.spring.boot.authentication.annotation.IgnoreAuthentication;
import org.toolkit.spring.boot.authentication.configuration.properties.AuthenticationConfigurationProperties;
import org.toolkit.spring.boot.utils.bean.BeanUtil;

@AutoConfiguration
@Slf4j
public class PermitAutoConfiguration {

	@Resource
	private BeanUtil beanUtil;

	@Resource
	private AuthenticationConfigurationProperties configurationProperties;

	@PostConstruct
	private void init() {
		log.atInfo().log("permit config executing");
	}

	@Bean
	public WebSecurityCustomizer webSecurityCustomizer() {
		val permitAllMatchers = Stream.concat(
						Arrays.stream(buildAntPathRequestMatcherFromAnnotation()),
						Arrays.stream(buildAntPathRequestMatcherFromConfig()))
				.distinct()
				.toArray(AntPathRequestMatcher[]::new);
		return (web) -> web.ignoring().requestMatchers(permitAllMatchers);
	}

	private AntPathRequestMatcher @NotNull [] buildAntPathRequestMatcherFromAnnotation() {
		return beanUtil.getBeansOfType(RequestMappingHandlerMapping.class).stream()
				.map(RequestMappingHandlerMapping::getHandlerMethods)
				.flatMap(method -> method.entrySet().stream())
				.filter(this::checkHasAnnotation)
				.flatMap(this::internalBuild)
				.distinct()
				.toArray(AntPathRequestMatcher[]::new);
	}

	private boolean checkHasAnnotation(Map.@NotNull Entry<RequestMappingInfo, HandlerMethod> method) {
		return method.getValue().hasMethodAnnotation(IgnoreAuthentication.class)
				|| method.getValue().hasMethodAnnotation(PermitAll.class);
	}

	@NotNull private Stream<AntPathRequestMatcher> internalBuild(Map.@NotNull Entry<RequestMappingInfo, HandlerMethod> entry) {
		return entry.getKey().getDirectPaths().stream()
				.filter(StrUtil::isNotBlank)
				.flatMap(path -> buildAnntPathByAnnotation(entry, path));
	}

	@NotNull private Stream<AntPathRequestMatcher> buildAnntPathByAnnotation(
			Map.@NotNull Entry<RequestMappingInfo, HandlerMethod> entry, String path) {
		val ann = entry.getValue().getMethodAnnotation(IgnoreAuthentication.class);
		if (Objects.isNull(ann)) {
			return entry.getValue().hasMethodAnnotation(PermitAll.class)
					? Stream.of(new AntPathRequestMatcher(path))
					: Stream.empty();
		}
		return Arrays.stream(ann.ignoreOnMethod())
				.distinct()
				.map(a -> new AntPathRequestMatcher(path, a.asHttpMethod().name()));
	}

	private AntPathRequestMatcher @NotNull [] buildAntPathRequestMatcherFromConfig() {
		return configurationProperties.getPermit().stream()
				.distinct()
				.flatMap(permit -> permit.getMethod().stream()
						.map(method -> new AntPathRequestMatcher(
								permit.getPattern(), method.asHttpMethod().name())))
				.toArray(AntPathRequestMatcher[]::new);
	}
}
