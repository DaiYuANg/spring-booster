package org.toolkit4j.framework.spring.starter.monitor.endpoint.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.Resource;
import java.util.Map;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.toolkit4j.framework.spring.starter.monitor.constants.Base;
import org.toolkit4j.framework.spring.starter.monitor.endpoint.services.IDevAdminService;
import org.toolkit4j.standard.restful.resp.Response;

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
	public Response<?> detect() {
		val r = objectMapper.readValue(devAdminService.actuatorExport(), Map.class);
		return Response.success(r);
	}
}
