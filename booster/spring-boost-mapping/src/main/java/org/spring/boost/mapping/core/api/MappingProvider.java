package org.spring.boost.mapping.core.api;

/**
 * Custom Mapping provider
 */
public interface MappingProvider {

  /**
   * @param value field value
   * @return mapped value
   */
  Object doMapping(Object value);
}
