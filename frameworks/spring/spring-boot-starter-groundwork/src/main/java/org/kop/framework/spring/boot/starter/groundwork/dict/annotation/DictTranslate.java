package org.kop.framework.spring.boot.starter.groundwork.dict.annotation;

import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DictTranslate {
    String code();

    String table() default "";

    String field() default "";
}
