/* (C)2023*/
package org.spring.boost.common.listener;

import static java.util.Objects.requireNonNullElse;

import java.net.InetAddress;
import lombok.RequiredArgsConstructor;
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
@RequiredArgsConstructor
public class StartUpListener {

	private final Environment env;

	@EventListener(ApplicationStartedEvent.class)
	@SneakyThrows
	public void listen(@NotNull ApplicationStartedEvent event) {
		val ip = InetAddress.getLocalHost().getHostAddress();
		val port = env.getProperty("server.port");
		val contextPath = requireNonNullElse(env.getProperty("server.servlet.context-path"), "/");
		log.atInfo().log("Server startup http://{}:{}{}", ip, port, contextPath);
		log.atInfo().log("time {} second", event.getTimeTaken().getSeconds());
	}
}
