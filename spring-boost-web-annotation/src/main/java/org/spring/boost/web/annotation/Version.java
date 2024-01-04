/* (C)2023*/
package org.spring.boost.web.annotation;

import java.lang.annotation.*;
import org.springframework.core.annotation.AliasFor;
import org.springframework.web.bind.annotation.Mapping;

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Mapping
public @interface Version {
    @AliasFor(value = "value")
    String version() default "";

    @AliasFor(value = "desc")
    String description() default "";

    ClientDevice device() default ClientDevice.ALL;
}
