package org.kop.framework.spring.boot.starter.dict.annotation;

import java.lang.annotation.*;

@Target({ElementType.TYPE,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DictDefine {
    String code() default "";
}
