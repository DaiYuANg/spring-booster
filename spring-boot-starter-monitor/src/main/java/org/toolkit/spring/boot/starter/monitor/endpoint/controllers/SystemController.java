package org.toolkit.spring.boot.starter.monitor.endpoint.controllers;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.toolkit.spring.boot.starter.monitor.constants.Base;
import org.toolkit.spring.boot.starter.monitor.endpoint.dto.LiveMemoryDto;
import org.toolkit.spring.boot.starter.monitor.endpoint.dto.LiveThreadDto;
import org.toolkit.spring.boot.starter.monitor.endpoint.services.ISystemInfoService;
import org.toolkit4j.framework.spring.boot.starter.restful.resp.Response;

@RestController
@Slf4j
@RequestMapping(Base.ROOT + "/system")
public class SystemController {
	@Resource
	private ISystemInfoService systemInfoService;

	@PostConstruct
	public void init() {

		// System.err.println(System.getProperties());
	}

	@GetMapping("/memoryAboutJvm")
	public Response<LiveMemoryDto> getMemory() {
		return Response.success(systemInfoService.getMemoryUsage());
	}

	@GetMapping("/threads")
	public Response<List<LiveThreadDto>> getThreads() {
		return Response.success(systemInfoService.getAllThreadOfCurrentJVM());
	}

	@GetMapping("/env")
	public Map<String, String> getRuntimeEnv() {
		return System.getenv();
	}

	@GetMapping("/prop")
	public Properties getRuntimeProperties() {
		return System.getProperties();
	}
}
