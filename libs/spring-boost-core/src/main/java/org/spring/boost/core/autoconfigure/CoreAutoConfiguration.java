/* (C)2023*/
package org.spring.boost.core.autoconfigure;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.spring.boost.core.api.BeanRegistry;
import org.spring.boost.core.context.SimpleBeanRegistry;
import org.spring.boost.core.model.PrintContext;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

@AutoConfiguration
@Slf4j
@EnableConfigurationProperties(CoreConfigurationProperties.class)
@RequiredArgsConstructor
@Import(cn.hutool.extra.spring.SpringUtil.class)
public class CoreAutoConfiguration {

  @PostConstruct
  void initialize() {
    log.atInfo().log("Initializing CoreAutoConfiguration");
  }

  @Bean(bootstrap = Bean.Bootstrap.BACKGROUND)
  BeanRegistry beanRegistry(
    ApplicationContext context, DefaultListableBeanFactory listableBeanFactory) {
    return SimpleBeanRegistry.builder()
      .context(context)
      .beanFactory(listableBeanFactory)
      .build();
  }

  @Bean
  PrintContext.PrintContextBuilder printContext() {
    return PrintContext.builder();
  }
}
