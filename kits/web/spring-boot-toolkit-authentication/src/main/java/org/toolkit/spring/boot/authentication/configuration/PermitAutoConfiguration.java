package org.toolkit.spring.boot.authentication.configuration;

import cn.hutool.core.util.StrUtil;
import cn.hutool.extra.spring.SpringUtil;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import jakarta.annotation.security.PermitAll;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.jetbrains.annotations.NotNull;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.context.annotation.Bean;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import org.toolkit.spring.boot.authentication.annotation.IgnoreAuthentication;
import org.toolkit.spring.boot.authentication.configuration.properties.AuthenticationConfigurationProperties;
import org.toolkit.spring.boot.authentication.constant.Method;

@AutoConfiguration
@Slf4j
@AutoConfigureBefore(AuthenticationAutoConfiguration.class)
public class PermitAutoConfiguration {

	@Resource
	private AuthenticationConfigurationProperties configurationProperties;

	@PostConstruct
	private void init() {
		log.atInfo().log("permit config executing");
	}

	@Bean(name = "PermitAllRequestMather")
	public List<AntPathRequestMatcher> webSecurityCustomizer() {
		val permitAllMatchers = Stream.concat(
						Arrays.stream(buildAntPathRequestMatcherFromAnnotation()),
						Arrays.stream(buildAntPathRequestMatcherFromConfig()))
				.distinct()
				.toList();
		log.atDebug().log(
				"permit route:{}",
				permitAllMatchers.stream().collect(Collectors.groupingBy(AntPathRequestMatcher::getPattern)));
		return permitAllMatchers;
	}

	private AntPathRequestMatcher @NotNull [] buildAntPathRequestMatcherFromAnnotation() {
		return SpringUtil.getBeansOfType(RequestMappingHandlerMapping.class).values().stream()
				.distinct()
				.map(RequestMappingHandlerMapping::getHandlerMethods)
				.flatMap(method -> method.entrySet().stream())
				.filter(this::checkHasAnnotation)
				.flatMap(this::internalBuild)
				.toArray(AntPathRequestMatcher[]::new);
	}

	private boolean checkHasAnnotation(Map.@NotNull Entry<RequestMappingInfo, HandlerMethod> method) {
		return method.getValue().hasMethodAnnotation(IgnoreAuthentication.class)
				|| method.getValue().hasMethodAnnotation(PermitAll.class);
	}

	@NotNull private Stream<AntPathRequestMatcher> internalBuild(Map.@NotNull Entry<RequestMappingInfo, HandlerMethod> entry) {
		return entry.getKey().getDirectPaths().stream()
				.filter(StrUtil::isNotBlank)
				.flatMap(path -> buildAntPathByAnnotation(entry, path));
	}

	@NotNull private Stream<AntPathRequestMatcher> buildAntPathByAnnotation(
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
		val allMethod = Arrays.stream(Method.ALL_METHOD).collect(Collectors.toUnmodifiableSet());
		return configurationProperties.getPermit().stream()
				.distinct()
				.peek(r -> {
					if (Objects.nonNull(r.getMethod())) return;
					r.setMethod(allMethod);
				})
				.flatMap(permit -> permit.getMethod().stream()
						.map(method -> new AntPathRequestMatcher(
								permit.getPattern(), method.asHttpMethod().name())))
				.toArray(AntPathRequestMatcher[]::new);
	}
}
