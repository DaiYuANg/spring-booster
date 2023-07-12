package org.kop.framework.spring.boot.starter.dict.annotation;

import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DictValue {
    String code();

    String text() default "";
}
