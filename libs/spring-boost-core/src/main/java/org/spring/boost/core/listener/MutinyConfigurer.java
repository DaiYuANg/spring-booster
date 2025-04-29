package org.spring.boost.core.listener;

import io.smallrye.mutiny.infrastructure.Infrastructure;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import net.dreamlu.mica.auto.annotation.AutoListener;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spring.boost.core.util.ContextUtil;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import java.util.concurrent.Executor;

@AutoListener
@Slf4j
public class MutinyConfigurer implements ApplicationListener<ContextRefreshedEvent> {
  @Override
  public void onApplicationEvent(@NotNull ContextRefreshedEvent event) {
    val executor = event.getApplicationContext().getBean("ioThreadPool", Executor.class);
    Infrastructure.setDefaultExecutor(executor);
    Infrastructure.setOperatorLogger((id, mutinyEvent, value, err) -> {
      val logger = LoggerFactory.getLogger(id);
      if (err != null) {
        logger.atInfo().log("{}({}({}))", mutinyEvent, err.getClass(), err.getMessage());
      } else {
        if (value != null) {
          logger.atInfo().log("{}({})", mutinyEvent, value);
        } else {
          logger.atInfo().log("{}()", mutinyEvent);
        }
      }
    });
  }
}
