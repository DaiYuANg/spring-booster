package org.toolkit.spring.boot.mapping.core.annotations;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Repeatable(Mapped.class)
public @interface Mapping {
	String value();
}
