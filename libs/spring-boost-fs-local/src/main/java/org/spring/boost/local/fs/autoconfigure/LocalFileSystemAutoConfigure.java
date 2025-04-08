package org.spring.boost.local.fs.autoconfigure;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.apache.tika.Tika;
import org.spring.boost.local.fs.service.LocalFileSystemService;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.net.URI;
import java.nio.file.*;
import java.util.Map;
import java.util.stream.Collectors;

@AutoConfiguration
@Slf4j
@RequiredArgsConstructor
@EnableConfigurationProperties(LocalFileSystemProperties.class)
public class LocalFileSystemAutoConfigure {
  private final LocalFileSystemProperties properties;

  private final ApplicationContext applicationContext;

  private final Tika tika;

  @PostConstruct
  void registerFileSystemServices() {
    val registry = (BeanDefinitionRegistry) applicationContext;

    // 遍历配置生成不同的 LocalFileSystemService Bean
    properties.getConfigs().forEach(config -> {
      GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
      beanDefinition.setBeanClass(LocalFileSystemService.class);
      beanDefinition.setScope(BeanDefinition.SCOPE_SINGLETON);
      beanDefinition.getConstructorArgumentValues().addGenericArgumentValue(tika);

      String beanName = config.getQualifier();
      registry.registerBeanDefinition(beanName, beanDefinition);
    });
  }
}
