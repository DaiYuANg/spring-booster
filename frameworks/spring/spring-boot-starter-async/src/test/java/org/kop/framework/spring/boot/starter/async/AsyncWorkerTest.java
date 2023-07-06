package org.kop.framework.spring.boot.starter.async;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = SpringBootApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
class AsyncWorkerTest {

    @Resource
    private AsyncWorker asyncWorker;

    @Test
    void init() {
        System.err.println(asyncWorker);
    }

    @Test
    void onShutdown() {
    }
}