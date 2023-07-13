package org.toolkit4j.framework.spring.starter.event.spring.annotations;

import java.lang.annotation.*;

@Target({ElementType.METHOD})
@Retention(value = RetentionPolicy.RUNTIME)
@Documented
public @interface MethodExecuted {
}
