package org.toolkit.spring.boot.starter.minio.handlers;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Slf4j
@Component
public class MinioHandler implements HttpRequestHandler {
	@SneakyThrows
	@Override
	public void handleRequest(@NotNull HttpServletRequest request, @NotNull HttpServletResponse response) {
		response.setContentType(MediaType.APPLICATION_JSON_VALUE);
		PrintWriter writer = response.getWriter();

		// 获取上传的文件
		MultipartFile file = ((MultipartHttpServletRequest) request).getFile("file");
	}
}
