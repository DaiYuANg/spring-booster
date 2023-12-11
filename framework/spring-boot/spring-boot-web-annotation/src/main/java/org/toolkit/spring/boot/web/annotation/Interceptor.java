package org.toolkit.spring.boot.web.annotation;

import java.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Interceptor {
	String[] value() default "";

	String[] excludePath() default "";

	int order() default 0;
}
