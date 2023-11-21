package org.toolkit.spring.boot.web.core.global;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import java.time.Instant;
import java.util.Objects;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.jetbrains.annotations.NotNull;
import org.springframework.core.MethodParameter;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;
import org.toolkit.spring.boot.web.annotation.IgnoreResponseAdvice;
import org.toolkit.spring.boot.web.core.configurations.WebCoreConfigurationProperties;
import org.toolkit.spring.boot.web.core.structure.Response;

@RestControllerAdvice
@Slf4j
public class ResponseHandler implements ResponseBodyAdvice<Object> {
	@Resource
	private WebCoreConfigurationProperties configurationProperties;

	@PostConstruct
	public void init() {
		log.info("init response handler");
	}

	@Override
	public boolean supports(
			@NotNull MethodParameter returnType, @NotNull Class<? extends HttpMessageConverter<?>> converterType) {
		val isMethodIgnore = Objects.isNull(returnType.getMethodAnnotation(IgnoreResponseAdvice.class));
		val isControllerIgnore = !returnType.getDeclaringClass().isAnnotationPresent(IgnoreResponseAdvice.class);
		val isResponse = returnType.getDeclaringClass() != configurationProperties.getReturnResult();
		return isControllerIgnore && isMethodIgnore && isResponse;
	}

	@SneakyThrows
	@Override
	public Object beforeBodyWrite(
			Object body,
			@NotNull MethodParameter returnType,
			@NotNull MediaType selectedContentType,
			@NotNull Class<? extends HttpMessageConverter<?>> selectedConverterType,
			@NotNull ServerHttpRequest request,
			@NotNull ServerHttpResponse response) {
		return processBody(body);
	}

	@SneakyThrows
	private @NotNull Object processBody(Object body) {
		if (body instanceof RepresentationModel) {
			return body;
		}
		if (body instanceof Instant) {
			return body;
		}
		var response = Response.success();
		if (Objects.nonNull(body)) {
			response = Response.success(body);
		}
		response.setVersion(Math.abs(response.hashCode()));
		return response;
	}
}
