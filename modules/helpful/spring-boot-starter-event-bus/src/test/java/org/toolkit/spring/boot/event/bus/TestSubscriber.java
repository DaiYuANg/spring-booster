package org.toolkit.spring.boot.event.bus;

import jakarta.annotation.PostConstruct;
import org.toolkit.spring.boot.event.bus.annotations.Subscriber;

@Subscriber(address = "test")
public class TestSubscriber {
	@PostConstruct
	public void test() {}
}
