package org.toolkit.spring.boot.starter.restful.interceptor;

import java.util.Objects;
import org.jetbrains.annotations.NotNull;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;
import org.toolkit.spring.boot.starter.restful.resp.Response;

@RestControllerAdvice
public class ResponseInterceptor implements ResponseBodyAdvice<Object> {
	@Override
	public boolean supports(
			@NotNull MethodParameter returnType, @NotNull Class<? extends HttpMessageConverter<?>> converterType) {
		return true;
	}

	@Override
	public Object beforeBodyWrite(
			Object body,
			@NotNull MethodParameter returnType,
			@NotNull MediaType selectedContentType,
			@NotNull Class<? extends HttpMessageConverter<?>> selectedConverterType,
			@NotNull ServerHttpRequest request,
			@NotNull ServerHttpResponse response) {
		if (body instanceof Response) return body;
		return Objects.nonNull(body) ? Response.success(body) : Response.success();
	}
}
