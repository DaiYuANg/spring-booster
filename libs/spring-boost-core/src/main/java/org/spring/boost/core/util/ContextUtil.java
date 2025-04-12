package org.spring.boost.core.util;

import lombok.experimental.UtilityClass;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.ApplicationContextEvent;

import java.util.Optional;

@UtilityClass
public class ContextUtil {

  public <T> Optional<T> getBeanFromEvent(ApplicationEvent event, Class<T> clazz) {
    if (event instanceof ApplicationContextEvent contextEvent) {
      return Optional.of(contextEvent.getApplicationContext().getBean(clazz));
    }
    return Optional.empty();
  }
}
