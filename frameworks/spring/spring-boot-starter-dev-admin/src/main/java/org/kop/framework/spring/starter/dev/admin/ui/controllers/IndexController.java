package org.kop.framework.spring.starter.dev.admin.ui.controllers;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.kop.framework.spring.starter.dev.admin.constants.Base;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(Base.ROOT)
@Slf4j
public class IndexController {

   @Resource
   private ApplicationContext context;

    @PostConstruct
    public void init() {
        log.info("dev admin init");
    }

    @GetMapping(Base.Paths.index)
    public String index(@NotNull Model model) {
        return Base.Paths.index;
    }
}
