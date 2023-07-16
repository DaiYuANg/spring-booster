package org.toolkit4J.examples.frameworks.spring.curd.example.events;

import com.google.common.eventbus.Subscribe;
import org.springframework.stereotype.Component;
import org.toolkit4J.framework.spring.starter.event.bus.EventBusSubscriber;

@EventBusSubscriber
@Component
public class TestDict {

	@Subscribe
	public void listen(Object object){

	}
}
