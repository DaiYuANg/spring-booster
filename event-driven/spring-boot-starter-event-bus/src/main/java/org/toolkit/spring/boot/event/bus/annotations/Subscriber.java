package org.toolkit.spring.boot.event.bus.annotations;

import java.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Subscriber {}
