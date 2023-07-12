package org.kop.framework.spring.boot.starter.async;

import lombok.extern.slf4j.Slf4j;
import org.junit.runner.RunWith;
import org.kop.framework.spring.boot.starter.async.config.AsyncWorkerAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = {SpringBootApplication.class, AsyncWorkerAutoConfiguration.class})
@RunWith(SpringRunner.class)
@Slf4j
class AsyncWorkerTest {

//    @Resource
//    private AsyncWorker asyncWorker;
//
//    @Test
//    void init() {
//        log.info(asyncWorker.toString());
//        asyncWorker.run(() -> log.info("test"));
//    }
//
//    @Test
//    void onShutdown() {
//    }
}