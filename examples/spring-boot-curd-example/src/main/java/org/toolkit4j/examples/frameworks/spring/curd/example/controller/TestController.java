package org.toolkit4j.examples.frameworks.spring.curd.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class TestController {

	@EventListener(ApplicationStartedEvent.class)
	@Async
	public void test(ApplicationStartedEvent event) {
		log.info("started");
	}

	@GetMapping("/test")
	//	@MethodExecuted
	public void test() {}
}
