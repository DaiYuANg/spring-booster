package org.toolkit.spring.boot.vertx.annotations;

import java.lang.annotation.*;
import org.springframework.stereotype.Component;

@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Component
public @interface EventConsumer {

	String address();
}
