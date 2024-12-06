package org.spring.boost.mutiny;

import io.smallrye.mutiny.infrastructure.Infrastructure;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import net.dreamlu.mica.auto.annotation.AutoListener;
import org.jetbrains.annotations.NotNull;
import org.springframework.context.*;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.task.TaskExecutor;

import java.util.concurrent.Executors;

@Slf4j
@AutoListener
public class MutinyContextInitializer implements ApplicationListener<ContextRefreshedEvent> {

  @Override
  public void onApplicationEvent(@NotNull ContextRefreshedEvent event) {
    log.atInfo().log("Setup mutiny");
    val context = event.getApplicationContext();
    val task = context.getBean("applicationTaskExecutor", TaskExecutor.class);
    Infrastructure.setOperatorLogger(new MutinySlf4jLogger());
    Infrastructure.setDefaultExecutor(task);
  }
}
