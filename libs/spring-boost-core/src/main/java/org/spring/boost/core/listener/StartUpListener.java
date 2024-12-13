/* (C)2023*/
package org.spring.boost.core.listener;

import static java.util.Objects.requireNonNullElse;

import java.net.InetAddress;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.jetbrains.annotations.NotNull;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Slf4j
@RequiredArgsConstructor
public class StartUpListener implements ApplicationListener<ApplicationStartedEvent> {

  private final Environment env;

  @Override
  public void onApplicationEvent(@NotNull ApplicationStartedEvent event) {
    val ip = InetAddress.getLoopbackAddress().getHostAddress();
    val port = env.getProperty("server.port");
    val contextPath = requireNonNullElse(env.getProperty("server.servlet.context-path"), "/");
    log.atInfo().log("Server startup http://{}:{}{}", ip, port, contextPath);
    log.atInfo().log("time {} second", event.getTimeTaken().getSeconds());
  }
}
