package org.spring.boost.core.reflect;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.function.Supplier;

@RequiredArgsConstructor
@Getter
public enum FieldProcessorEnum {
  COLLECTION(CollectionProcessor::new),

  OBJECT(ObjectProcessor::new);

  private final Supplier<FieldProcessor> value;
}
