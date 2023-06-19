package org.kop.examples.frameworks.spring.curd.example.controller;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.kop.libs.thready.async.AsyncWorker;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class TestController {
    @Resource
    private AsyncWorker asyncWorker;

    @GetMapping("/test")
    public void test() {
        asyncWorker.run(()-> {
            System.err.println(123);
        });
    }
}
