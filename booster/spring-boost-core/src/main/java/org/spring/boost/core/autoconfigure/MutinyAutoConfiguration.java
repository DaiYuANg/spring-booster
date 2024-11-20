package org.spring.boost.core.autoconfigure;

import io.smallrye.mutiny.infrastructure.Infrastructure;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@AutoConfiguration
@RequiredArgsConstructor
@EnableAsync
@EnableScheduling
public class MutinyAutoConfiguration {

  private final TaskExecutor taskExecutor;

  @PostConstruct
  void initMutinyLogging() {
    Infrastructure.setDefaultExecutor(taskExecutor);
    Infrastructure.setOperatorLogger((id, event, value, err) -> {
      Logger logger = LoggerFactory.getLogger(id);
      if (err != null) {
        logger.atInfo().log("{}({}({}))", event, err.getClass(), err.getMessage());
      } else {
        if (value != null) {
          logger.atInfo().log("{}({})", event, value);
        } else {
          logger.atInfo().log("{}()", event);
        }
      }
    });
  }
}
