package org.toolkit4J.framework.spring.boot.starter.locker.request.annotations;

import java.lang.annotation.*;
import java.util.concurrent.TimeUnit;

@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface RequestLimit {
    int limitDuration() default 1;

    TimeUnit limitTimeUnit() default TimeUnit.SECONDS;
}
