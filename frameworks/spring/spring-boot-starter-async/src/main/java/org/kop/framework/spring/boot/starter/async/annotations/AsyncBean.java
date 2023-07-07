package org.kop.framework.spring.boot.starter.async.annotations;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AsyncBean {
}
