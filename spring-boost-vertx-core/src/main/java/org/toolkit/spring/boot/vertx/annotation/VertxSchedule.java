/* (C)2023*/
package org.toolkit.spring.boot.vertx.annotation;

import java.lang.annotation.*;
import java.util.concurrent.TimeUnit;

@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface VertxSchedule {
	long delay();

	TimeUnit unit();
}
