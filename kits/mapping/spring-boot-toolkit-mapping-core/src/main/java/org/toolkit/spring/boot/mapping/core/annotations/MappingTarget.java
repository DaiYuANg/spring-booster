package org.toolkit.spring.boot.mapping.core.annotations;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface MappingTarget {
    /**
     *
     * @return a class type for pretreatment
     */
    Class<?> pretreatment() default MappingTarget.class;
}
