package org.toolkit.example.all.events;

import io.vertx.core.eventbus.Message;
import java.util.concurrent.TimeUnit;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.toolkit.spring.boot.event.bus.annotations.Subscribe;
import org.toolkit.spring.boot.event.bus.annotations.Subscriber;

@Subscriber
@Slf4j
public class TestDict {

	@SneakyThrows
	@Subscribe(address = "application")
	public void listen(@NotNull Message<Integer> object) {
		log.info("receive message:{}", object.body());
		TimeUnit.SECONDS.sleep(5);
		object.reply("got you");
	}
}
