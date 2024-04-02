package org.spring.boost.mapping.core.module;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.spring.boost.core.api.BeanRegistry;

@Slf4j
public class MappingSerializer extends JsonSerializer<Object> {
  private final BeanRegistry beanRegistry;

  private final ObjectMapper internalObjectMapper = new ObjectMapper();

  public MappingSerializer(BeanRegistry beanRegistry) {
    this.beanRegistry = beanRegistry;
  }

  @SneakyThrows
  @Override
  public void serialize(
    @NotNull Object o,
    @NotNull JsonGenerator jsonGenerator,
    SerializerProvider serializerProvider) {
//    val objectNode = internalObjectMapper.convertValue(o, ObjectNode.class);
//    val service = beanRegistry.get(KeyValueMappingProvider.class);
//    val interceptor = beanRegistry.get(MappingInterceptor.class);
//    doWithFields(
//      o.getClass(),
//      field -> {
//        var fieldValue = field.get(o);
//        fieldValue = Optional.ofNullable(interceptor.reflectValue(fieldValue)).orElse(fieldValue);
//
//        val mappingAnnotation = field.getAnnotation(Mapping.class);
//
//        var text = service.doMapping(mappingAnnotation.key(), fieldValue);
//
//        text = Optional.ofNullable(interceptor.mapping(text)).orElse(text);
//
//        val name =
//          mappingAnnotation.overrideOrigin()
//            ? field.getName()
//            : String.format(mappingAnnotation.customFieldName(), field.getName());
//
//        objectNode.put(name, text);
//
//        interceptor.afterMapping(objectNode);
//      },
//      field -> Objects.nonNull(field.getAnnotation(Mapping.class)));
//
//    val mappingResult = internalObjectMapper.writeValueAsBytes(objectNode);
//
//    jsonGenerator.writeBinary(mappingResult);
  }
}
