package org.toolkit.spring.boot.web.core.annotations;

import java.lang.annotation.*;
import org.springframework.core.annotation.AliasFor;
import org.springframework.web.bind.annotation.Mapping;
import org.toolkit.spring.boot.web.core.constant.ClientDevice;

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Mapping
public @interface Version {
	@AliasFor(value = "value")
	String version() default "";

	@AliasFor(value = "desc")
	String description() default "";

	ClientDevice device() default ClientDevice.ALL;
}
