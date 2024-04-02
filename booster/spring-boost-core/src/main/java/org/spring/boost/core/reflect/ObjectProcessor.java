package org.spring.boost.core.reflect;

import java.lang.reflect.Field;
import java.util.Set;
import java.util.function.BiConsumer;

public class ObjectProcessor implements FieldProcessor{

  public final Set<Class<?>> wrapperClasses = Set.of(
    String.class,
    Long.class,
    Boolean.class,
    Short.class,
    Integer.class,
    Double.class,
    Float.class,
    Byte.class,
    Character.class
  );
  @Override
  public void process(Field field, Object value, BiConsumer<Field, Object> consumer) {

  }
}
