package org.spring.boost.core.reflect;

import java.lang.reflect.Field;
import java.util.function.BiConsumer;

public interface FieldProcessor {
  void process(Field field, Object value, BiConsumer<Field, Object> consumer);
}
