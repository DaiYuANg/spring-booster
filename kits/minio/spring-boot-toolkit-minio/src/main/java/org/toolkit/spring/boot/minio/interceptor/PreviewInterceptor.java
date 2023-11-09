package org.toolkit.spring.boot.minio.interceptor;

import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Slf4j
@Component
public class PreviewInterceptor implements HandlerInterceptor {

	@Resource
	private ApplicationEventPublisher eventPublisher;

	@Override
	public boolean preHandle(
			@NotNull HttpServletRequest request, @NotNull HttpServletResponse response, @NotNull Object handler) {

		return true;
	}
}
