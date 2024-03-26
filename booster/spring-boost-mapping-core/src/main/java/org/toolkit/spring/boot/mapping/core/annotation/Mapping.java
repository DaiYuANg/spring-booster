/* (C)2023*/
package org.toolkit.spring.boot.mapping.core.annotation;

import org.toolkit.spring.boot.mapping.core.api.MappingService;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Mapping {

  /**
   * Mapping key
   *
   * @return key
   */
  String key();

  /**
   * Is strict
   *
   * @return true or false
   */
  boolean strict() default false;

  boolean overrideOrigin() default false;

  String customFieldName() default "%sTranslated";

  Class<? extends MappingService> service() default MappingService.class;
}
