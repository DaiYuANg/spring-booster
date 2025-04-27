package org.spring.boost.admin.lifecycle;

import io.javalin.Javalin;
import lombok.extern.slf4j.Slf4j;
import net.dreamlu.mica.auto.annotation.AutoListener;
import org.jetbrains.annotations.NotNull;
import org.spring.boost.core.util.ContextUtil;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;

@AutoListener
@SuppressWarnings("unused")
@Slf4j
public class ShutdownListener implements ApplicationListener<ContextClosedEvent> {
  @Override
  public void onApplicationEvent(@NotNull ContextClosedEvent event) {
    ContextUtil.getBeanFromEvent(event, Javalin.class)
      .ifPresent(javalin -> {
        log.atTrace().log("Shutting down Javalin");
        javalin.stop();
      });
  }
}
