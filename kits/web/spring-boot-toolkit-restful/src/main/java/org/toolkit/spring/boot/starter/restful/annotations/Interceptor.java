package org.toolkit.spring.boot.starter.restful.annotations;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

@Component
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Interceptor {
    String[] value() default "";

    String[] excludePath() default "";

    int order() default 0;
}
