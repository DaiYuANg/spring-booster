/* (C)2023*/
package org.toolkit.spring.boot.mapping.core.configuration;

import lombok.extern.slf4j.Slf4j;
import net.bytebuddy.ByteBuddy;
import org.spring.boost.core.api.BeanRegistry;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.toolkit.spring.boot.mapping.core.module.MappingBeanDeserializerModifier;
import org.toolkit.spring.boot.mapping.core.module.MappingModule;
import org.toolkit.spring.boot.mapping.core.module.MappingSerializer;

/**
 * @author daiyuang
 * Mapping Core Auto Configure
 */
@AutoConfiguration
@EnableConfigurationProperties(MappedConfigurationProperties.class)
@Slf4j
public class MappedAutoConfiguration {
  @Bean
  ByteBuddy byteBuddy() {
    return new ByteBuddy();
  }

  @Bean
  MappingSerializer mappingSerializer(BeanRegistry beanRegistry) {
    return new MappingSerializer(beanRegistry);
  }

  @Bean
  MappingBeanDeserializerModifier mappingBeanDeserializerModifier(
      MappingSerializer mappingSerializer) {
    return new MappingBeanDeserializerModifier(mappingSerializer);
  }

  @Bean
  MappingModule mappingModule(MappingBeanDeserializerModifier mappingBeanDeserializerModifier) {
    return new MappingModule(mappingBeanDeserializerModifier);
  }

  @Bean
  Jackson2ObjectMapperBuilderCustomizer customizer(MappingModule module) {
    return jacksonObjectMapperBuilder -> jacksonObjectMapperBuilder.modulesToInstall(module);
  }
}
