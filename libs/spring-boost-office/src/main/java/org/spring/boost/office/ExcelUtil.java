/* (C)2024*/
package org.spring.boost.office;

import lombok.experimental.UtilityClass;
import org.spring.boost.office.annotation.ExcelObject;
import org.springframework.util.ReflectionUtils;

@UtilityClass
public class ExcelUtil {
  public static void extractHeader(Class<?> entityClass) {
    ReflectionUtils.doWithFields(entityClass, field -> {
    }, field -> field.isAnnotationPresent(ExcelObject.class));
  }
}
