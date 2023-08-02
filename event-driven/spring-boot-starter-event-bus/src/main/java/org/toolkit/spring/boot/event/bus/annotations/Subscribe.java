package org.toolkit.spring.boot.event.bus.annotations;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Subscribe {
    String address();
}
