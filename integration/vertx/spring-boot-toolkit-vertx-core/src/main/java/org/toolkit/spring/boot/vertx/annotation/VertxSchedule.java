package org.toolkit.spring.boot.vertx.annotation;

import lombok.extern.slf4j.Slf4j;

import java.lang.annotation.*;
import java.util.concurrent.TimeUnit;

@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface VertxSchedule {
    long delay();

    TimeUnit unit();
}
