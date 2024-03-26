package org.toolkit.spring.boot.mapping.core.module;

import static org.springframework.util.ReflectionUtils.doWithFields;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.Objects;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.jetbrains.annotations.NotNull;
import org.spring.boost.core.api.BeanRegistry;
import org.toolkit.spring.boot.mapping.core.annotation.Mapping;
import org.toolkit.spring.boot.mapping.core.api.MappingInterceptor;
import org.toolkit.spring.boot.mapping.core.api.MappingService;

@RequiredArgsConstructor
@Slf4j
public class MappingSerializer extends JsonSerializer<Object> {
  private final BeanRegistry beanRegistry;

  private final ObjectMapper internalObjectMapper = new ObjectMapper();

  @SneakyThrows
  @Override
  public void serialize(
      @NotNull Object o,
      @NotNull JsonGenerator jsonGenerator,
      SerializerProvider serializerProvider) {
    val objectNode = internalObjectMapper.convertValue(o, ObjectNode.class);
    val service = beanRegistry.get(MappingService.class);
    val interceptor = beanRegistry.get(MappingInterceptor.class);
    doWithFields(
        o.getClass(),
        field -> {
          var fieldValue = field.get(o);
          fieldValue = Optional.ofNullable(interceptor.reflectValue(fieldValue)).orElse(fieldValue);

          val mappingAnnotation = field.getAnnotation(Mapping.class);

          var text = service.doMapping(mappingAnnotation.key(), fieldValue);

          text = Optional.ofNullable(interceptor.mapping(text)).orElse(text);

          val name =
              mappingAnnotation.overrideOrigin()
                  ? field.getName()
                  : String.format(mappingAnnotation.customFieldName(), field.getName());

          objectNode.put(name, text);

          interceptor.afterMapping(objectNode);
        },
        field -> Objects.nonNull(field.getAnnotation(Mapping.class)));

    val mappingResult = internalObjectMapper.writeValueAsBytes(objectNode);

    jsonGenerator.writeBinary(mappingResult);
  }
}
