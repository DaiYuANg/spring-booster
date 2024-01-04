/* (C)2024*/
package org.spring.boost.minio.factory;

import lombok.experimental.SuperBuilder;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.spring.boost.minio.BeanNaming;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/**
 * @author daiyuang
 * @since 2024.1.4
 */
@SuperBuilder
@Slf4j
public class MinioTemplateBeanFactoryPostProcessor extends TemplateFactory implements BeanFactoryPostProcessor {

    /**
     * Register @see{@link org.spring.boost.minio.MinioTemplate} MinioTemplate Key of spring ioc is
     * And naming is @see{@link org.spring.boost.minio.properties.MinioConfigurationProperties}
     * clients key + @see{@link BeanNaming} TEMPLATE
     *
     * @param beanFactory Spring Listable Bean Factory
     * @throws BeansException Not throws
     */
    @Override
    public void postProcessBeanFactory(@NotNull ConfigurableListableBeanFactory beanFactory) throws BeansException {
        properties.getClients().forEach((k, v) -> registerTemplates(k, beanFactory, v));
    }
}
