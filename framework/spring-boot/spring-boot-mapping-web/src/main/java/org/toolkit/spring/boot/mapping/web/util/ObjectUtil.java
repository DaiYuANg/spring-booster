package org.toolkit.spring.boot.mapping.web.util;

import java.lang.reflect.InaccessibleObjectException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.Objects;
import java.util.function.Consumer;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.jetbrains.annotations.NotNull;
import org.springframework.util.ReflectionUtils;

@UtilityClass
@Slf4j
public class ObjectUtil {

	public void walkObject(Object obj, int depth) {
		Map<String, Map<String, Object>> a;
		if (depth == 0 || Objects.isNull(obj)) return;
		System.out.println("Class: " + obj.getClass() + ", Value: " + obj);
		ReflectionUtils.doWithFields(obj.getClass(), field -> {
			try {
				field.setAccessible(true);
				Object fieldValue = field.get(obj);
				System.out.println("Field: " + field.getName() + ", Value: " + fieldValue);
				// Read annotations on the field
				val annotations = field.getAnnotations();
				Arrays.stream(annotations)
						.map(annotation -> "Annotation on field " + field.getName() + ": " + annotation)
						.forEach(System.out::println);
				//                val mappingAnnotation = field.getAnnotation(Mapping.class);
				//                val nestAnnotation = field.getAnnotation(NestMapping.class);
				// Recursively process nested objects
				if (field.getType().isPrimitive() || field.getType().equals(String.class)) {
					return; // Early return for primitive types and strings
				}

				if (field.getType().isArray() || Collection.class.isAssignableFrom(field.getType())) {
					// For arrays and collections, iterate through elements
					forEachElement(fieldValue, element -> walkObject(element, depth - 1));
				} else {
					// For other objects, recursively process
					walkObject(fieldValue, depth - 1);
				}
			} catch (InaccessibleObjectException e) {
				log.atWarn().log("Field:{} can not accessed", field.getName());
			}
		});
	}

	private void forEachElement(@NotNull Object collectionOrArray, Consumer<Object> action) {
		if (collectionOrArray.getClass().isArray()) {
			Arrays.stream((Object[]) collectionOrArray).forEach(action);
			return;
		}
		if (collectionOrArray instanceof Collection) {
			// For collections, iterate through elements and apply the action
			((Collection<?>) collectionOrArray).forEach(element -> {
				// Recursively process nested objects in the collection
				if (element != null
						&& !element.getClass().isPrimitive()
						&& !element.getClass().equals(String.class)) {
					walkObject(element, Integer.MAX_VALUE);
				}
				// Apply the action on the element
				action.accept(element);
			});
		}
	}
}
