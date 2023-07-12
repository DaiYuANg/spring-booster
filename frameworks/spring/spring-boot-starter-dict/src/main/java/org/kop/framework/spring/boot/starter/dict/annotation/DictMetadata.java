package org.kop.framework.spring.boot.starter.dict.annotation;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DictMetadata {
    String code();

    String desc() default "";
}
