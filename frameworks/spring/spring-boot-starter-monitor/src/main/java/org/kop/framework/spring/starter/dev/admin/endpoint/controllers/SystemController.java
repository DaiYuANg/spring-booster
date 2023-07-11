package org.kop.framework.spring.starter.dev.admin.endpoint.controllers;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.kop.framework.spring.starter.dev.admin.constants.Base;
import org.kop.framework.spring.starter.dev.admin.endpoint.dto.LiveMemoryDto;
import org.kop.framework.spring.starter.dev.admin.endpoint.dto.LiveThreadDto;
import org.kop.framework.spring.starter.dev.admin.endpoint.services.ISystemInfoService;
import org.kop.standard.restful.resp.Response;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.Properties;

@RestController
@Slf4j
@RequestMapping(Base.ROOT + "/system")
public class SystemController {
    @Resource
    private ISystemInfoService systemInfoService;

    @SneakyThrows
    @PostConstruct
    public void init() {

//        System.err.println(System.getProperties());
    }

    @GetMapping("/memoryAboutJvm")
    public Response<LiveMemoryDto> getMemory() {
        return Response.ok(systemInfoService.getMemoryUsage());
    }

    @GetMapping("/threads")
    public Response<List<LiveThreadDto>> getThreads() {
        return Response.ok(systemInfoService.getAllThreadOfCurrentJVM());
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
