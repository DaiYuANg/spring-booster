package org.toolkit.spring.boot.starter.monitor.endpoint.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.Resource;
import java.util.Map;
import java.util.Optional;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.toolkit.spring.boot.starter.monitor.constants.Base;
import org.toolkit.spring.boot.starter.monitor.endpoint.services.IDevAdminService;

@RestController
@RequestMapping(Base.ROOT)
@Slf4j
public class DevAdminController {
	@Resource
	IDevAdminService devAdminService;

	@Resource
	private ObjectMapper objectMapper;

	@SneakyThrows
	@GetMapping("/detect")
	public ResponseEntity<?> detect() {
		val r = objectMapper.readValue(devAdminService.actuatorExport(), Map.class);
		return ResponseEntity.of(Optional.ofNullable(r));
	}
}
