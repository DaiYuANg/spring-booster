package org.spring.boost.core.annotation;

import org.slf4j.event.Level;

import java.lang.annotation.*;
import java.util.concurrent.TimeUnit;

@Target(
  ElementType.METHOD
)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Timed {
  TimeUnit unit() default TimeUnit.MILLISECONDS;

  String logTemplate() default "{method} executed in {time} {unit}";

  Level level() default Level.TRACE;

  interface Template {
    String METHOD = "method";

    String TIME = "time";

    String UNIT = "unit";
  }
}
