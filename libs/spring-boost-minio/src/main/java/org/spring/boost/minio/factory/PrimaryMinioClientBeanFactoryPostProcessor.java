/* (C)2024*/
package org.spring.boost.minio.factory;

import java.util.Optional;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import okhttp3.OkHttpClient;
import org.jetbrains.annotations.NotNull;
import org.spring.boost.minio.BeanNaming;
import org.spring.boost.minio.autoconfigure.properties.MinioConfigurationProperties;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.core.annotation.Order;

@Slf4j
@RequiredArgsConstructor
@Order(1)
public class PrimaryMinioClientBeanFactoryPostProcessor extends ClientFactory implements BeanFactoryPostProcessor {
  private final MinioConfigurationProperties properties;

  private final OkHttpClient okHttpClient;

  @Override
  public void postProcessBeanFactory(@NotNull ConfigurableListableBeanFactory beanFactory) throws BeansException {
//    Optional.ofNullable(properties.getPrimary()).ifPresent(primaryClient -> {
//      val minioPrimaryClient = createClient(primaryClient, okHttpClient);
//      val key = BeanNaming.buildAdminName(BeanNaming.CLIENT);
//      beanFactory.registerSingleton(key, minioPrimaryClient);
//      beanFactory.getBeanDefinition(key).setPrimary(true);
//      log.atTrace().log("Register Minio Client:{}:{}", key, minioPrimaryClient);
//    });
  }
}
