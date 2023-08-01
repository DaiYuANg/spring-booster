package org.toolkit4j.framework.spring.boot.starter.recording.annotation;

import java.lang.annotation.*;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Recorder {
	String content() default "";

	String fail() default "";

	String operator() default "";

	String detail() default "";

	String condition() default "";
}
