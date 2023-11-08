package org.toolkit.spring.boot.starter.mapped.annotations;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Mapped {
    Mapping[] value();
}
