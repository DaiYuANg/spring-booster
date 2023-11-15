package org.toolkit.spring.boot.mapping.core.annotations;

import org.toolkit.spring.boot.mapping.core.base.MappingSource;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Repeatable(MappingProperty.class)
public @interface Mapping {
    String key();

    String field() default "";

    Class<? extends MappingSource>[] mappingSource() default {MappingSource.class};
}
