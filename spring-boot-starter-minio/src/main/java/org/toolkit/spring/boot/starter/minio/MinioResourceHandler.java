package org.toolkit.spring.boot.starter.minio;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.resource.ResourceHttpRequestHandler;
import org.toolkit.spring.boot.starter.minio.configurations.MinioConfigurationProperties;

@Slf4j
public class MinioResourceHandler extends ResourceHttpRequestHandler {
	@jakarta.annotation.Resource
	private MinioConfigurationProperties minioConfigurationProperties;

	@Override
	protected MediaType getMediaType(@NotNull HttpServletRequest request, @NotNull Resource resource) {
		return super.getMediaType(request, resource);
	}

	@Override
	public void handleRequest(@NotNull HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getRequestURI().startsWith(minioConfigurationProperties.getAccessPrefix())) {
			//            todo
		}
	}
}
