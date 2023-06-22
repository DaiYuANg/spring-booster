package org.kop.framework.spring.boot.starter.groundwork.log.annotation;

import java.lang.annotation.*;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Record {
    String content() default "";

    String fail() default "";

    String operator() default "";

    String detail() default "";

    String condition() default "";
}
