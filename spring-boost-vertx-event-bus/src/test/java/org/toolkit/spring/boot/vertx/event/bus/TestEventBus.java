/* (C)2023*/
package org.toolkit.spring.boot.vertx.event.bus;

import io.vertx.core.eventbus.EventBus;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import java.util.concurrent.TimeUnit;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class TestEventBus {

	@Resource
	private EventBus eventBus;

	@PostConstruct
	public void test() {
		log.info("test");
	}

	@Scheduled(fixedDelay = 1, timeUnit = TimeUnit.SECONDS)
	public void init() {
		log.info("test");
		eventBus.publish("test", "test event bus");
	}
}
