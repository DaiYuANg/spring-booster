package org.kop.frameworks.spring.starter.helpers.examples;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import org.daiyuang.libs.thready.async.AsyncWorker;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExampleController {
    @Resource
    AsyncWorker asyncWorker;

    @PostConstruct
    public void init() {
        asyncWorker.run(() -> System.err.println(123));
    }
}
