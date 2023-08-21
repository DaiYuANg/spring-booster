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
import oshi.SystemInfo;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.software.os.OperatingSystem;

@RestController
@Slf4j
@RequestMapping(Base.ROOT + "/system")
public class SystemController {
	@Resource
	private ISystemInfoService systemInfoService;

	@PostConstruct
	public void init() {
		log.info("system info init");
		// System.err.println(System.getProperties());
	}

	@GetMapping("/memoryAboutJvm")
	public LiveMemoryDto getMemory() {
		return systemInfoService.getMemoryUsage();
		//		return Response.success(systemInfoService.getMemoryUsage());
	}

	@GetMapping("/threads")
	public List<LiveThreadDto> getThreads() {
		return systemInfoService.getAllThreadOfCurrentJVM();
	}

	@GetMapping("/env")
	public Map<String, String> getRuntimeEnv() {
		return System.getenv();
	}

	@GetMapping("/prop")
	public Properties getRuntimeProperties() {
		return System.getProperties();
	}

	@GetMapping("/operationSystem")
	public OperatingSystem querySystemInfo(){
		log.info("query system info");
		systemInfoService.querySystemInfo().getOperatingSystem()
		return systemInfoService.querySystemInfo().getOperatingSystem();
	}

	@GetMapping("/hardware")
	public HardwareAbstractionLayer querySystemHardware(){
		log.info("query system info");
		return systemInfoService.querySystemInfo().getHardware();
	}
}
