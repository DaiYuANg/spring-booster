/* (C)2023*/
package org.spring.boost.core.autoconfigure;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.jetbrains.annotations.NotNull;
import org.spring.boost.core.api.BeanRegistry;
import org.spring.boost.core.context.SimpleBeanRegistry;
import org.spring.boost.core.listener.StartUpListener;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.core.env.Environment;

@AutoConfiguration
@Slf4j
@EnableConfigurationProperties(CoreConfigurationProperties.class)
@RequiredArgsConstructor
@Import(cn.hutool.extra.spring.SpringUtil.class)
public class CoreAutoConfiguration {

  @Bean()
  BeanRegistry beanRegistry(
      ApplicationContext context, DefaultListableBeanFactory listableBeanFactory) {
    return SimpleBeanRegistry.builder().context(context).beanFactory(listableBeanFactory).build();
  }

  @Bean
  StartUpListener startUpListener(Environment environment) {
    return new StartUpListener(environment);
  }
}
