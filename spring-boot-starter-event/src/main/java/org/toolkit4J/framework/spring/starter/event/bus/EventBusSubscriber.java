package org.toolkit4J.framework.spring.starter.event.bus;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface EventBusSubscriber {
	String bus() default "default";

	String description() default "";
}
