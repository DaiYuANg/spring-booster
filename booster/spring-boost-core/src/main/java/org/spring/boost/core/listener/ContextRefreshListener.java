/* (C)2024*/
package org.spring.boost.core.listener;

import lombok.Cleanup;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import net.dreamlu.mica.auto.annotation.AutoListener;
import org.jetbrains.annotations.NotNull;
import org.spring.boost.core.autoconfigure.CoreConfigurationProperties;
import org.springframework.boot.context.event.ApplicationPreparedEvent;
import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.context.ApplicationListener;

import java.util.ServiceLoader;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

import static io.smallrye.mutiny.Multi.createFrom;

@Slf4j
@AutoListener
@SuppressWarnings("unused")
public class ContextRefreshListener implements ApplicationListener<ApplicationPreparedEvent> {
  private final ThreadFactory threadFactory = Thread.ofPlatform()
    .name(this.getClass().getName() + "-", 0)
    .factory();

  private final int parallel = Runtime.getRuntime().availableProcessors() * 2;

  public ContextRefreshListener() {
  }

  @Override
  @SuppressWarnings({"StaticImport", "ImmutableListBuilder"})
  public void onApplicationEvent(@NotNull ApplicationPreparedEvent event) {
    val mainClass = event.getSpringApplication().getMainApplicationClass();
    val context = event.getApplicationContext();
    val binder = Binder.get(context.getEnvironment());
    val config = CoreConfigurationProperties.get(binder);
    @Cleanup val executor = Executors.newThreadPerTaskExecutor(threadFactory);
    log.atTrace().log("Boost Core Listener Active");
    log.atTrace().log("Core config:{}", config);
  }

  @Override
  public boolean supportsAsyncExecution() {
    return true;
  }
}
