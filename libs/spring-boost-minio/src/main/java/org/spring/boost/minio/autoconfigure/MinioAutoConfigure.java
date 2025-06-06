/* (C)2024*/
package org.spring.boost.minio.autoconfigure;

import java.util.Set;
import java.util.stream.Collectors;

import io.minio.MinioClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import okhttp3.OkHttpClient;
import org.apache.tika.Tika;
import org.jetbrains.annotations.NotNull;
import org.spring.boost.minio.service.MinioTemplate;
import org.spring.boost.minio.interceptor.EventMinioInterceptor;
import org.spring.boost.minio.interceptor.MinioInterceptor;
import org.spring.boost.minio.autoconfigure.properties.MinioConfigurationProperties;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;

/**
 * Spring boot auto configure
 *
 * @author daiyuang
 * @since 2024.1.4
 */
@AutoConfiguration
@EnableConfigurationProperties(MinioConfigurationProperties.class)
@Slf4j
@Order
public class MinioAutoConfigure {

  /**
   * Custom OkHttpClient for minio client
   *
   * @return @see{@link okhttp3.OkHttpClient}
   */
  @Bean
  OkHttpClient.Builder okHttpClientBuilder() {
    return new OkHttpClient.Builder();
  }

  /**
   * For automatic detect object content type
   *
   * @return @see{@link org.apache.tika.Tika}
   */
  @Bean(name = "TikaForMinio")
  Tika tika() {
    return new Tika();
  }

  /**
   * Bundled event hook for minio hooks
   *
   * @param applicationEventPublisher spring event publisher
   * @return @see{@link EventMinioInterceptor}
   */
  @Bean
  EventMinioInterceptor eventMinioHook(ApplicationEventPublisher applicationEventPublisher) {
    return new EventMinioInterceptor(applicationEventPublisher);
  }

  @Bean
  Set<MinioInterceptor> hooks(@NotNull ConfigurableListableBeanFactory beanFactory) {
    return beanFactory.getBeansOfType(MinioInterceptor.class).values().stream().collect(Collectors.toUnmodifiableSet());
  }

  @Bean
  OkHttpClient okHttpClient(OkHttpClient.@NotNull Builder builder) {
    return builder.build();
  }

  @Bean
  MinioClient minioClient(MinioConfigurationProperties minioConfigurationProperties) {
    val primary = minioConfigurationProperties.getPrimary();
    return MinioClient.builder()
      .credentials(primary.getAccessKey(), primary.getSecretKey())
      .endpoint(primary.getEndpoint())
      .region(primary.getRegionOptional().orElse(null))
      .build();
  }

  @Bean
  MinioTemplate minioTemplate(MinioClient client,MinioConfigurationProperties minioConfigurationProperties) {
    val primary = minioConfigurationProperties.getPrimary();
    return MinioTemplate.builder().minioClient(client)
      .config(primary)
      .build();
  }
}
