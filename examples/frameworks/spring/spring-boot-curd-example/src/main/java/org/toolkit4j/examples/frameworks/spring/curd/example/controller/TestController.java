package org.toolkit4J.examples.frameworks.spring.curd.example.controller;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.toolkit4j.framework.spring.boot.starter.async.base.AsyncWorker;
import org.toolkit4j.framework.spring.starter.event.spring.annotations.MethodExecuted;

@RestController
@Slf4j
public class TestController {
	@Resource
	private AsyncWorker asyncWorker;

	@EventListener(ApplicationStartedEvent.class)
	@Async
	public void test(ApplicationStartedEvent event) {
		log.info("started");
	}

	@GetMapping("/test")
	@MethodExecuted
	public void test() {
		asyncWorker.run(() -> System.err.println(123));
	}
}
