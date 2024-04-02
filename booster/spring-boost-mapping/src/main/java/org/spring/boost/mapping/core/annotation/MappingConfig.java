package org.spring.boost.mapping.core.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Target({})
@Retention(RetentionPolicy.RUNTIME)
public @interface MappingConfig {
  String fieldName();

  Class<?> serialType() default String.class;
}
