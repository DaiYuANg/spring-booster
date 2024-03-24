package org.toolkit.spring.boot.mapping.core.module;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.module.SimpleSerializers;
import com.fasterxml.jackson.databind.ser.Serializers;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.toolkit.spring.boot.mapping.core.service.MappingService;

import java.io.IOException;

@Slf4j
@RequiredArgsConstructor
public class MappingSerializer extends JsonSerializer<Object> {

  private MappingService mappingService;

  @Override
  public void serialize(
      Object o, JsonGenerator jsonGenerator, SerializerProvider serializerProvider)
      throws IOException {}
}
