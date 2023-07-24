package org.toolkit4J.examples.frameworks.spring.curd.example.controller;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.toolkit4J.framework.spring.starter.event.spring.annotations.MethodExecuted;
import org.toolkit4j.libs.thready.async.AsyncWorker;

@RestController
@Slf4j
public class TestController {

	@EventListener(ApplicationStartedEvent.class)
	@Async
	public void test(ApplicationStartedEvent event) {
		log.info("started");
	}

	@GetMapping("/test")
	@MethodExecuted
	public void test() {
	}
}
