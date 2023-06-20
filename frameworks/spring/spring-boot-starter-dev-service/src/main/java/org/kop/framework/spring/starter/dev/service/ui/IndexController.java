package org.kop.framework.spring.starter.dev.service.ui;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController(value = "/")
public class IndexController {
    @GetMapping("/dev/service")
    public ModelAndView index() {
        System.err.println(123);
        return new ModelAndView();
    }
}
