package org.spring.boost.core.annotation;

import java.lang.annotation.*;

@Target(
  ElementType.METHOD
)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Timed {
}
