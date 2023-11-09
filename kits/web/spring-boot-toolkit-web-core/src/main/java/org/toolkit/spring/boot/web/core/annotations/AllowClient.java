package org.toolkit.spring.boot.web.core.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import org.toolkit.spring.boot.web.core.constant.ClientDevice;

@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AllowClient {
	ClientDevice device() default ClientDevice.ALL;
}
