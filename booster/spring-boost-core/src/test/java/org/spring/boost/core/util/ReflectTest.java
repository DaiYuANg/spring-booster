package org.spring.boost.core.util;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.spring.boost.core.reflect.Reflect;

@Slf4j
class ReflectTest {

  // 示例嵌套对象
  @Data
  static class NestedObject {
    private final String nestedField = "NestedValue";
  }

  // 示例对象
  @Data
  static class ExampleObject {
    private final int primitiveField = 123;
    private final String stringField = "Hello";
    private final NestedObject nestedObject = new NestedObject();
  }

  @Test
  void traverseObject() {
    Reflect.builder()
      .build()
      .traverseObject(new ExampleObject(), (field, o) -> {
        log.info("field:{}", field.getName());
        log.info("value:{}", o);
      });
  }
}