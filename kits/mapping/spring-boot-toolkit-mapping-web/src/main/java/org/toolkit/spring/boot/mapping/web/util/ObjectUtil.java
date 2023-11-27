package org.toolkit.spring.boot.mapping.web.util;

import lombok.experimental.UtilityClass;
import lombok.val;
import org.jetbrains.annotations.NotNull;
import org.springframework.util.ReflectionUtils;
import org.toolkit.spring.boot.mapping.core.annotations.Mapping;
import org.toolkit.spring.boot.mapping.core.annotations.NestMapping;

import java.util.Arrays;
import java.util.Objects;

@UtilityClass
public class ObjectUtil {

    public void walkObject(@NotNull Object obj, int depth) {
        if (depth == 0) return;
        ReflectionUtils.doWithFields(obj.getClass(), field -> {
            field.setAccessible(true);
            Object fieldValue = field.get(obj);
            System.out.println("Field: " + field.getName() + ", Value: " + fieldValue);
            // Read annotations on the field
            val annotations = field.getAnnotations();
            Arrays.stream(annotations)
                    .map(annotation -> "Annotation on field " + field.getName() + ": " + annotation)
                    .forEach(System.out::println);
            val mappingAnnotation = field.getAnnotation(Mapping.class);
            val nestAnnotation = field.getAnnotation(NestMapping.class);
            // Recursively process nested objects
            if (fieldValue != null && !field.getType().isPrimitive() && Objects.nonNull(nestAnnotation)) {
                walkObject(fieldValue, depth - 1);
            }
        });
    }
}
