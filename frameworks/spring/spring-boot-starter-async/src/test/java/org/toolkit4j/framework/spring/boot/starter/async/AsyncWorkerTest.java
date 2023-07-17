package org.toolkit4j.framework.spring.boot.starter.async;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.toolkit4J.framework.spring.boot.starter.async.base.AsyncWorker;
import org.toolkit4J.framework.spring.boot.starter.async.configuration.AsyncWorkerAutoConfiguration;

import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

@SpringBootTest(classes = {SpringBootApplication.class, AsyncWorkerAutoConfiguration.class})
@RunWith(SpringRunner.class)
@Slf4j
class AsyncWorkerTest {

	@Resource
	private AsyncWorker asyncWorker;

	@Test
	public void init() {
		log.info(asyncWorker.toString());
		asyncWorker.run(() -> log.info("test"));
	}

	@Test
	public void testParallel() {
		val tasks = IntStream.range(0, 10)
				.mapToObj(r -> (Runnable) () -> {
					try {
						TimeUnit.SECONDS.sleep(4);
						log.info("parallel run");
					} catch (InterruptedException e) {
						throw new RuntimeException(e);
					}
				})
				.toList();
		asyncWorker.parallelALL(tasks).join();
	}
	//
	// @Test
	// void onShutdown() {
	// }
}
