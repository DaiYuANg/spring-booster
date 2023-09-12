package org.toolkit.spring.boot.event.bus;

import io.vertx.core.eventbus.EventBus;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;
import org.toolkit.spring.boot.event.bus.configurations.EventBusConfiguration;

@SpringBootTest(classes = {SpringBootApplication.class, EventBusConfiguration.class, TestSubscriber.class})
@RunWith(SpringRunner.class)
@ComponentScan({"org.toolkit.spring.boot.event.bus.*"})
public class TestStartUp {

	@Resource
	private EventBus eventBus;

	@Test
	public void testStartUp() {
		eventBus.publish("dsds", "dasdas");
		assert eventBus != null;
	}

	@Test
	public void testPublish() {
		eventBus.publish("test", "dasdas");
	}
}
