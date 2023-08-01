package org.toolkit4j.framework.spring.boot.starter.dict.annotations;

import java.lang.annotation.*;
import org.springframework.stereotype.Component;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface DictMetadata {
	String code();

	String desc() default "";

	int order() default 0;
}
