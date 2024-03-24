package org.toolkit.spring.boot.mapping.core.module;

import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.module.SimpleSerializers;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.jetbrains.annotations.NotNull;

@Slf4j
@RequiredArgsConstructor
public class MappingModule extends SimpleModule {

  private final MappingSerializer mappingSerializer;

  @Override
  public void setupModule(@NotNull SetupContext context) {
    val serializers = new SimpleSerializers();
    // 添加您自定义的序列化器
    serializers.addSerializer(mappingSerializer);
    context.addSerializers(serializers);
  }
}
