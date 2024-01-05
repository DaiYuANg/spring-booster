/* (C)2024*/
package org.spring.boost.minio.factory;

import java.util.Optional;
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

/**
 * Primary minio admin client factory
 *
 * @author daiyuang
 */
@Slf4j
@RequiredArgsConstructor
@Order(2)
public class PrimaryMinioAdminBeanFactoryPostProcessor extends AdminClientFactory implements BeanFactoryPostProcessor {
    private final MinioConfigurationProperties minioConfigurationProperties;

    private final OkHttpClient okHttpClient;

    @Override
    public void postProcessBeanFactory(@NotNull ConfigurableListableBeanFactory beanFactory) throws BeansException {
        Optional.ofNullable(minioConfigurationProperties.getClient()).ifPresent(primaryAdminClient -> {
            val minioAdminClient = createMinioAdminClient(primaryAdminClient, okHttpClient);
            val key = BeanNaming.buildAdminName(BeanNaming.ADMIN);
            beanFactory.registerSingleton(key, minioAdminClient);
            beanFactory.getBeanDefinition(key).setPrimary(true);
            log.atTrace().log("Register Primary Minio Admin Client:{}:{}", key, minioAdminClient);
        });
    }
}
