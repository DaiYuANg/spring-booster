package org.kop.framework.spring.starter.dev.service.ui;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {
    @GetMapping("/devservice")
    public String index() {
        System.err.println(123);
        return "devservice.html";
    }
}
