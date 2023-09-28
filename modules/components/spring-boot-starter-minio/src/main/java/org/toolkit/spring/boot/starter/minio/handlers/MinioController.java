package org.toolkit.spring.boot.starter.minio.handlers;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@RestController
@RequestMapping("${toolkit.minio.context:/minio}")
public class MinioController {
	@Value("${toolkit.minio.context:/minio}")
	private String controllerPrefix;

	@PostConstruct
	public void init() {
		System.err.println(controllerPrefix);
	}

	@RequestMapping(
			value = "${toolkit.minio.context:/minio}/hello",
			method = {RequestMethod.POST, RequestMethod.PUT})
	@ResponseBody
	public String hello(@RequestParam("file") MultipartFile file) {
		return "Hello, Spring Boot!";
	}
}
