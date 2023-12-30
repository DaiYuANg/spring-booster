/* (C)2023*/
package org.toolkit.spring.boot.utils.listener;

import jakarta.annotation.Resource;
import java.net.InetAddress;
import java.util.Optional;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.jetbrains.annotations.NotNull;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class StartUpListener {

	@Resource
	private Environment env;

	@SneakyThrows
	@EventListener(ApplicationStartedEvent.class)
	public void listen(@NotNull ApplicationStartedEvent event) {
		val ip = InetAddress.getLocalHost().getHostAddress();
		val port = env.getProperty("server.port");
		val contextPath = Optional.ofNullable(env.getProperty("server.servlet.context-path"))
				.orElse("/");
		log.atInfo().log("Server startup http://{}:{}{}", ip, port, contextPath);
		log.atInfo().log("time {} second", event.getTimeTaken().getSeconds());
	}
}
