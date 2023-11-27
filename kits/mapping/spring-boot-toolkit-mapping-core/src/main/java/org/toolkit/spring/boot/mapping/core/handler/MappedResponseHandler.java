package org.toolkit.spring.boot.mapping.core.handler;

import org.jetbrains.annotations.NotNull;
import org.springframework.core.MethodParameter;
import org.springframework.core.annotation.Order;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;
import org.toolkit.spring.boot.mapping.core.utils.MappedUtil;

@ControllerAdvice
@Order
public class MappedResponseHandler implements ResponseBodyAdvice<Object> {
	@Override
	public boolean supports(
			@NotNull MethodParameter returnType, @NotNull Class<? extends HttpMessageConverter<?>> converterType) {
		return MappedUtil.isMappedTarget(returnType.getParameterType());
	}

	@Override
	public Object beforeBodyWrite(
			Object body,
			@NotNull MethodParameter returnType,
			@NotNull MediaType selectedContentType,
			@NotNull Class<? extends HttpMessageConverter<?>> selectedConverterType,
			@NotNull ServerHttpRequest request,
			@NotNull ServerHttpResponse response) {
		return null;
	}
}
