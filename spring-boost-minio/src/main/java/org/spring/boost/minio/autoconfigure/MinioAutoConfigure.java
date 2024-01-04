/* (C)2024*/
package org.spring.boost.minio.autoconfigure;

import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import org.apache.tika.Tika;
import org.jetbrains.annotations.NotNull;
import org.spring.boost.minio.hook.EventMinioHook;
import org.spring.boost.minio.hook.MinioHook;
import org.spring.boost.minio.properties.MinioConfigurationProperties;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;

import java.util.Set;
import java.util.stream.Collectors;

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
    @ConditionalOnMissingBean
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
     * @return @see{@link EventMinioHook}
     */
    @Bean
    EventMinioHook eventMinioHook(ApplicationEventPublisher applicationEventPublisher) {
        return new EventMinioHook(applicationEventPublisher);
    }

    @Bean
    Set<MinioHook> hooks(@NotNull ConfigurableListableBeanFactory beanFactory) {
        return beanFactory.getBeansOfType(MinioHook.class).values().stream().collect(Collectors.toUnmodifiableSet());
    }

    @Bean
    OkHttpClient okHttpClient(OkHttpClient.@NotNull Builder builder) {
        return builder.build();
    }
}
