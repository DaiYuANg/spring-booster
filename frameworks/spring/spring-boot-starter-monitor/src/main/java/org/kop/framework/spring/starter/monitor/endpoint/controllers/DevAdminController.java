package org.kop.framework.spring.starter.monitor.endpoint.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.Resource;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.kop.framework.spring.starter.monitor.constants.Base;
import org.kop.framework.spring.starter.monitor.endpoint.services.IDevAdminService;
import org.kop.standard.restful.resp.Response;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

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
        return Response.ok(r);
    }
}
