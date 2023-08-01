package org.toolkit4j.framework.spring.boot.starter.dict.annotations;

import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DictValue {
	String code();

	String text() default "";
}
