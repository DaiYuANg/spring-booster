package org.toolkit.spring.boot.starter.dict.annotations;

import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DictTranslate {
	String code();

	String table() default "";

	String field() default "";
}
