package org.toolkit4J.framework.spring.boot.starter.async.bean;

import jakarta.annotation.PostConstruct;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Component
public class AsyncAnnotationBeanPostProcessor implements BeanPostProcessor {

    @PostConstruct
    public void init(){
    }

    @Override
    public Object postProcessBeforeInitialization(@NotNull Object bean, @NotNull String beanName)
            throws BeansException {
        return bean;
    }

    @SneakyThrows
    @Async
    public void invokePostConstructAsync(Object bean, @NotNull Method postConstructMethod) {
        postConstructMethod.invoke(bean);
    }
}
