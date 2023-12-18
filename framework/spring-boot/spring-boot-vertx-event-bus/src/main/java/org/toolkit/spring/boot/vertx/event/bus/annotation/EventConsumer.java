/* (C)2023*/
package org.toolkit.spring.boot.vertx.event.bus.annotation;

import java.lang.annotation.*;
import org.springframework.stereotype.Component;

@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Component
public @interface EventConsumer {

	String value();
}
