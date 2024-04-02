package org.spring.boost.mapping.core.module;

import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.ser.BeanSerializerModifier;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.spring.boost.mapping.core.annotation.Mapping;

@Slf4j
@RequiredArgsConstructor
public class MappingBeanDeserializerModifier extends BeanSerializerModifier {

  private final MappingSerializer mappingSerializer;

  @Override
  public JsonSerializer<?> modifySerializer(
    SerializationConfig config, @NotNull BeanDescription beanDesc, JsonSerializer<?> serializer) {
    return beanDesc.findProperties().stream()
        .filter(prop -> Objects.nonNull(prop.getPrimaryMember()))
        .filter(prop -> prop.getPrimaryMember().hasAnnotation(Mapping.class))
        .findFirst()
        .<JsonSerializer<?>>map(prop -> mappingSerializer)
        .orElse(serializer);
  }
}
