/* (C)2023*/
package org.toolkit.spring.boot.mapping.base.annotation;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Repeatable(MappingProperty.class)
public @interface Mapping {
	String key();

	String field() default "";

	boolean immutable() default true;
}
