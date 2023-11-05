package org.toolkit.spring.boot.starter.vertx.annotations;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Component
public @interface EventConsumer {

    String address();
}
