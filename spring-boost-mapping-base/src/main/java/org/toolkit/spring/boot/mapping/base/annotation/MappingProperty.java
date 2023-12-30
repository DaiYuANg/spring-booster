/* (C)2023*/
package org.toolkit.spring.boot.mapping.base.annotation;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface MappingProperty {
	Mapping[] value();
}
