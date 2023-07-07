package org.kop.framework.spring.boot.starter.async.bean;

import lombok.SneakyThrows;
import lombok.val;
import org.jetbrains.annotations.NotNull;
import org.kop.framework.spring.boot.starter.async.annotations.AsyncBean;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.boot.ApplicationContextFactory;
import org.springframework.boot.WebApplicationType;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.core.Ordered;
import org.springframework.core.PriorityOrdered;

import java.lang.reflect.Field;
import java.util.PriorityQueue;

public class AsyncBeanRegister implements ApplicationContextInitializer<ConfigurableApplicationContext>, Ordered {
    @SneakyThrows
    @Override
    public void initialize(@NotNull ConfigurableApplicationContext context) {
        val beanFactory = new AsyncBeanFactory(context.getBeanFactory());
        Field field = GenericApplicationContext.class.getDeclaredField("beanFactory");
        field.setAccessible(true);
        field.set(context, beanFactory);
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
