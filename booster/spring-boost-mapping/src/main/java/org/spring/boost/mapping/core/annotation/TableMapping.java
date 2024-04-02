package org.spring.boost.mapping.core.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({})
public @interface TableMapping {
  /**
   * specified table
   *
   * @return from table
   */
  String table();

  /**
   * specified field
   *
   * @return select field
   */
  String field();

  /**
   * where condition field
   *
   * @return condition field
   */
  String condition();

  MappingConfig config();
}
