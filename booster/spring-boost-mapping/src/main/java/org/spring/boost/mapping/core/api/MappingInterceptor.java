package org.spring.boost.mapping.core.api;

import com.fasterxml.jackson.databind.node.ObjectNode;

public interface MappingInterceptor {

  default Object reflectValue(Object value) {
    return null;
  }

  default String mapping(String text) {
    return null;
  }

  default void afterMapping(ObjectNode objectNode) {}
}
