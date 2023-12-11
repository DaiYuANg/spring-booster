package org.toolkit.spring.boot.mapping.source.code.annotation;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface StaticField {
	String key();

	String text() default "";

	String description() default "";
}
