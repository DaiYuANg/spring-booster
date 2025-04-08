/* (C)2024*/
package org.spring.boost.minio.factory;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import okhttp3.OkHttpClient;
import org.jetbrains.annotations.NotNull;
import org.spring.boost.minio.BeanNaming;
import org.spring.boost.minio.properties.MinioConfigurationProperties;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.core.annotation.Order;

@Slf4j
@RequiredArgsConstructor
@Order(1)
public class MinioClientBeanFactoryPostProcessor extends ClientFactory implements BeanFactoryPostProcessor {

  private final MinioConfigurationProperties properties;

  private final OkHttpClient okHttpClient;

  /**
   * Register minio client instance into spring ioc And naming is @see{@link
   * org.spring.boost.minio.properties.MinioConfigurationProperties} clients key
   */
  @Override
  public void postProcessBeanFactory(@NotNull ConfigurableListableBeanFactory beanFactory) throws BeansException {
    properties.getClients().forEach((key, value) -> {
      val client = createClient(value, okHttpClient);
      val beanName = BeanNaming.buildAdminName(key, BeanNaming.CLIENT);
      log.atTrace().log("Register Minio Client:{}:{}", beanName, client);
      beanFactory.registerSingleton(beanName, client);
    });
  }
}
