package org.spring.boost.core.model;

import lombok.Builder;
import lombok.Singular;
import lombok.ToString;

import java.util.HashMap;
import java.util.Map;

@Builder
@ToString
public class PrintContext {

  @Singular
  private final Map<String, String> printContents = new HashMap<>();
}
