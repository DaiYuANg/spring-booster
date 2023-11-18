package org.toolkit.spring.boot.web.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AllowClient {
	ClientDevice device() default ClientDevice.ALL;
}
