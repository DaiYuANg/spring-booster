/* (C)2023*/
package org.toolkit.spring.boot.recorder.annotation;

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
