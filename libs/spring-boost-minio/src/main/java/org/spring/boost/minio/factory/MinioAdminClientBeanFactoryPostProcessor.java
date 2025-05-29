/* (C)2024*/
package org.spring.boost.minio.factory;

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

@RequiredArgsConstructor
@Slf4j
@Order(2)
public class MinioAdminClientBeanFactoryPostProcessor extends AdminClientFactory implements BeanFactoryPostProcessor {
  private final MinioConfigurationProperties minioConfigurationProperties;

  private final OkHttpClient okHttpClient;

  /**
   * Register minio admin client instance into spring ioc And naming is @see{@link
   * MinioConfigurationProperties} clients key + @see{@link
   * BeanNaming} ADMIN
   */
  @Override
  public void postProcessBeanFactory(@NotNull ConfigurableListableBeanFactory beanFactory) throws BeansException {
//    minioConfigurationProperties.getClients().forEach((key, value) -> {
//      val client = createMinioAdminClient(value, okHttpClient);
//      val adminBeanKey = BeanNaming.buildAdminName(key, BeanNaming.ADMIN);
//      log.atTrace().log("Register Minio Admin Client:{}:{}", adminBeanKey, client);
//      beanFactory.registerSingleton(adminBeanKey, client);
//    });
  }
}
