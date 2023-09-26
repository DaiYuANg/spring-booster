package org.toolkit.spring.boot.starter.minio.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.web.servlet.HandlerInterceptor;

@Slf4j
public class PreviewInterceptor implements HandlerInterceptor {

	private final String interceptPrefix;

	public PreviewInterceptor(String interceptPrefix) {
		this.interceptPrefix = interceptPrefix;
	}

	@Override
	public boolean preHandle(
			@NotNull HttpServletRequest request, @NotNull HttpServletResponse response, @NotNull Object handler)
			throws Exception {
		return false;
	}
}
