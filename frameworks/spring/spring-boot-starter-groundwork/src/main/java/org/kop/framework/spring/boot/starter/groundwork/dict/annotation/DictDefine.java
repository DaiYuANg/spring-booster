package org.kop.framework.spring.boot.starter.groundwork.dict.annotation;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DictDefine {
    String code() default "";
}
