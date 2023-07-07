package org.kop.framework.spring.boot.starter.async.bean;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.BeansException;
import org.springframework.context.annotation.CommonAnnotationBeanPostProcessor;

public class AsyncCommonAnnotationBeanPostProcessor extends CommonAnnotationBeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(@NotNull Object bean, @NotNull String beanName) throws BeansException {

        return super.postProcessBeforeInitialization(bean, beanName);
    }
}
