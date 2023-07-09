package org.kop.framework.spring.starter.dev.admin.endpoint.controllers;

import jakarta.annotation.Resource;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.kop.framework.spring.starter.dev.admin.constants.Base;
import org.kop.framework.spring.starter.dev.admin.endpoint.services.IDevAdminService;
import org.kop.framework.spring.starter.dev.admin.endpoint.services.ISystemInfoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(Base.ROOT)
@Slf4j
public class DevAdminController {
    @Resource
    private ISystemInfoService systemInfoService;

    @Resource
    IDevAdminService devAdminService;

    @SneakyThrows
    @GetMapping("/detect")
    public String root() {
        return devAdminService.currentSystem();
    }
}
