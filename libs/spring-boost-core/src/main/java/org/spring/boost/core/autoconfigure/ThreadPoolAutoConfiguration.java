package org.spring.boost.core.autoconfigure;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

@AutoConfiguration
@Slf4j
@RequiredArgsConstructor
public class ThreadPoolAutoConfiguration {

  private final Integer cpuCorePoolSize = Runtime.getRuntime().availableProcessors();

  @Bean("bootstrapExecutor")
  public Executor bootstrapExecutor() {
    val taskExecutor = new ThreadPoolTaskExecutor();
    taskExecutor.setCorePoolSize(cpuCorePoolSize);
    taskExecutor.setMaxPoolSize(cpuCorePoolSize * 2);
    taskExecutor.initialize();
    return taskExecutor;
  }

  @Bean("ioThreadPool")
  public Executor ioThreadPool() {
    val factory = Thread.ofVirtual().name("io-thread", 0).factory();
    return Executors.newThreadPerTaskExecutor(factory);
  }
}
