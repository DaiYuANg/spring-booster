/* (C)2023*/
package org.spring.boost.mapping.core.annotation;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Mapping {

  KeyValueMapping[] kvMappings() default {};

  TableMapping[] tableMappings() default {};

  ProviderMapping[] providers() default {};

  /**
   * Is strict
   *
   * @return true or false
   */
  boolean strict() default false;
}
