package org.spring.boost.core.reflect;

import lombok.NoArgsConstructor;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.function.BiConsumer;

@NoArgsConstructor
public class CollectionProcessor implements FieldProcessor {
  @Override
  public void process(Field field, Object value, BiConsumer<Field, Object> consumer) {
    if (Boolean.FALSE.equals(value instanceof Collection<?>)) {
      return;
    }
    for (Object element : (Collection<?>) value) {
      consumer.accept(field, element);
    }
  }
}
