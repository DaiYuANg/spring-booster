package org.kop.framework.spring.starter.dev.admin.endpoint.controllers;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.kop.framework.spring.starter.dev.admin.constants.Base;
import org.kop.framework.spring.starter.dev.admin.endpoint.services.ISystemInfoService;
import org.springframework.context.ApplicationContext;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(Base.ROOT)
@Slf4j
public class IndexController {
   @Resource
   private ApplicationContext context;
   @Resource
   private ISystemInfoService systemInfoService;

    @PostConstruct
    public void init() {
        log.info("dev admin init");
    }

    @GetMapping(Base.Paths.index)
    public String index(@NotNull Model model) {
        return Base.Paths.index;
    }
}
