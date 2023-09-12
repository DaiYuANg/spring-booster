package org.toolkit.spring.boot.event.bus;

import org.springframework.stereotype.Component;
import org.toolkit.spring.boot.event.bus.annotations.Subscribe;
import org.toolkit.spring.boot.event.bus.annotations.Subscriber;

@Subscriber
@Component
public class TestSubscriber {
	@Subscribe(address = "test")
	public void sub(Object message) {
		System.err.println(message);
	}
}
