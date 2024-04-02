package org.spring.boost.mapping.core.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({})
public @interface KeyValueMapping {
  /**
   * target key
   *
   * @return key
   */
  String value();

  MappingConfig config();
}
