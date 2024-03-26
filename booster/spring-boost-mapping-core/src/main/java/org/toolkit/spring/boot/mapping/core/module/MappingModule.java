package org.toolkit.spring.boot.mapping.core.module;

import com.fasterxml.jackson.databind.module.SimpleModule;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
public class MappingModule extends SimpleModule {

  private final MappingBeanDeserializerModifier mappingBeanDeserializerModifier;
  @Override
  public void setupModule(SetupContext context) {
    super.setupModule(context);
    context.addBeanSerializerModifier(mappingBeanDeserializerModifier);
  }
}
