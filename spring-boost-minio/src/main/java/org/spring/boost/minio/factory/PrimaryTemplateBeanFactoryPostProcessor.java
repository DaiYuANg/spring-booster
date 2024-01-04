/* (C)2024*/
package org.spring.boost.minio.factory;

import lombok.experimental.SuperBuilder;
import lombok.extern.slf4j.Slf4j;
import org.apache.tika.Tika;
import org.jetbrains.annotations.NotNull;
import org.spring.boost.minio.properties.MinioConfigurationProperties;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

import java.util.Optional;

@SuperBuilder
@Slf4j
public class PrimaryTemplateBeanFactoryPostProcessor extends TemplateFactory implements BeanFactoryPostProcessor {
    private final MinioConfigurationProperties properties;

    private final Tika tika;

    @Override
    public void postProcessBeanFactory(@NotNull ConfigurableListableBeanFactory beanFactory) throws BeansException {
        Optional.ofNullable(properties.getClient()).ifPresent(minioClientConfig -> registerTemplates("", beanFactory, minioClientConfig));
    }
}
