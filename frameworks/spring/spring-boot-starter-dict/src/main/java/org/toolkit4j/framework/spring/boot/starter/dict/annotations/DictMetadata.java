package org.toolkit4j.framework.spring.boot.starter.dict.annotations;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DictMetadata {
	String code();

	String desc() default "";

	int order() default 0;
}
