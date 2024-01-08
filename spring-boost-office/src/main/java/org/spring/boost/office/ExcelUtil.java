package org.spring.boost.office;

import com.github.benmanes.caffeine.cache.CacheLoader;
import lombok.experimental.UtilityClass;
import org.spring.boost.office.annotation.ExcelObject;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;

@UtilityClass
public class ExcelUtil {

    public static void extractHeader(Class<?> entityClass) {
        ReflectionUtils.doWithFields(entityClass, field -> {
        }, new ReflectionUtils.FieldFilter() {
            @Override
            public boolean matches(Field field) {
                return field.isAnnotationPresent(ExcelObject.class);
            }
        });
    }
}
