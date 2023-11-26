package org.toolkit.spring.boot.mapping.source.code.annotation;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface StaticField {
    String value();

    int order() default Integer.MIN_VALUE;
}
