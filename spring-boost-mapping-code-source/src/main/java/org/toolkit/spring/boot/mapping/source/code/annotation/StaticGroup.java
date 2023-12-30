/* (C)2023*/
package org.toolkit.spring.boot.mapping.source.code.annotation;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface StaticGroup {

	String description() default "";
}
