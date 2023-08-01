package org.toolkit.example.all.events;

import com.google.common.eventbus.Subscribe;
import org.springframework.stereotype.Component;

// @EventBusSubscriber
@Component
public class TestDict {

	@Subscribe
	public void listen(Object object) {}
}
