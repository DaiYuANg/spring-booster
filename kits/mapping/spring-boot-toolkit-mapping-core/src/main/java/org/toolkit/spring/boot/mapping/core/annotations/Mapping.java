package org.toolkit.spring.boot.mapping.core.annotations;

import java.lang.annotation.*;
import org.toolkit.spring.boot.mapping.core.base.MappingSource;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Repeatable(MappingProperty.class)
public @interface Mapping {
	String key();

	String field() default "";

	Class<? extends MappingSource>[] mappingSource() default {MappingSource.class};
}
