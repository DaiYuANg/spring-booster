package org.toolkit.spring.boot.starter.minio.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.toolkit.spring.boot.starter.minio.functional.MinioTemplate;
import org.toolkit.spring.boot.starter.minio.repositories.MinioResourceAccessEntityRepository;

@Slf4j
public class PreviewInterceptor implements HandlerInterceptor {

	private static final String USER_AGENT_HEADER = "user-agent";

	private final MinioTemplate minioTemplate;

	private final MinioResourceAccessEntityRepository minioResourceAccessEntityRepository;

	public PreviewInterceptor(
			MinioTemplate minioTemplate, MinioResourceAccessEntityRepository minioResourceAccessEntityRepository) {
		this.minioTemplate = minioTemplate;
		this.minioResourceAccessEntityRepository = minioResourceAccessEntityRepository;
	}

	@Override
	public boolean preHandle(
			@NotNull HttpServletRequest request, @NotNull HttpServletResponse response, @NotNull Object handler) {
		log.atDebug().log(request.getRequestURI());
		return false;
	}

	@Override
	public void postHandle(
			HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
			throws Exception {
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
		Optional.ofNullable(request.getHeader(USER_AGENT_HEADER));
	}
}
